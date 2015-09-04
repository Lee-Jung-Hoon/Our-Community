package kr.co.mlec.community.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import kr.co.mlec.community.dao.WorkInfoDAO;
import kr.co.mlec.community.vo.WorkInfoVO;

@WebServlet("/workInfo/regist")
public class WorkInfoWriteController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		List<WorkInfoVO> list = new ArrayList<>();
		try {
			String calUrl = "http://api.saramin.co.kr/job-search?" 
								+ "keywords=프로그래머" 
								+ "&sort=pd" 
								+ "&loc_cd=101000"
								+ "&count=10" 
								+ "&output=xml";
			URL url = new URL(calUrl);
			InputStream in = url.openStream();

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(in);

			NodeList workInfoList = doc.getElementsByTagName("job");
			int childLen = workInfoList.getLength();

			for (int index = 0; index < childLen; index++) {
				WorkInfoVO vo = new WorkInfoVO();
				WorkInfoDAO dao = new WorkInfoDAO();

				Node node = workInfoList.item(index);
				NodeList childList = node.getChildNodes();

				for (int j = 0; j < childList.getLength(); j++) {

					Node cNode = childList.item(j);
					String cName = cNode.getNodeName();
					String cValue = cNode.getTextContent();
					if ("#text".equals(cName))
						continue;

					if ("id".equals(cName)) {
						vo.setId(cValue);
					} else if ("url".equals(cName)) {
						vo.setUrl(cValue);
					} else if ("active".equals(cName)) {
						vo.setActive("1".equals(cValue) ? "진행중" : "마감");
					} else if ("posting-timestamp".equals(cName)) {
						vo.setPostingTimeStamp(timeStamp(cValue));
					} else if ("opening-timestamp".equals(cName)) {
						vo.setOpeningTimeStamp(timeStamp(cValue));
					} else if ("expiration-timestamp".equals(cName)) {
						vo.setExpirationTimeStamp(timeStamp(cValue));
					} else if ("company".equals(cName)) {

						NodeList workInfoSecList = cNode.getChildNodes();

						for (int secIndex = 0; secIndex < workInfoSecList.getLength(); secIndex++) {
							Node comNode = workInfoSecList.item(secIndex);
							String comName = comNode.getNodeName();
							String comValue = comNode.getTextContent();
							if ("name".equals(comName)) {
								vo.setCompany(comValue);
							}
						}
					} else if ("position".equals(cName)) {
						NodeList workInfoThirdList = cNode.getChildNodes();

						for (int thirdIndex = 0; thirdIndex < workInfoThirdList.getLength(); thirdIndex++) {
							Node sNode = workInfoThirdList.item(thirdIndex);
							String sName = sNode.getNodeName();
							String sValue = sNode.getTextContent();
							if ("title".equals(sName)) {
								vo.setTitle(sValue);
							} else if ("job-type".equals(sName)) {
								vo.setJobType(sValue);
							} else if ("job-category".equals(sName)) {
								vo.setJobCategory(sValue);
							} else if ("open-quantity".equals(sName)) {
								vo.setOpenQuantity(sValue);
							} else if ("experience-level".equals(sName)) {
								vo.setExperienceLevel(sValue);
							}
						}
					} else if("salary".equals(cName)) {
						vo.setSalary(cValue);
					}
				}
				System.out.println(vo.getSalary());
				list.add(vo);
				dao.insertTemp(vo);
			}
			WorkInfoDAO wDao = new WorkInfoDAO();
			List<String> sList = wDao.selectCompanyId();
			for (String va : sList) {
				System.out.println("sList id " + va);
			}
			if (sList.size() != 0) {
				for (int index = 0; index < sList.size(); index++) {
					for (int secIndex = 0; secIndex < list.size(); secIndex++) {
						if (sList.get(index).equals(list.get(secIndex).getId())) {
							System.out
									.println("sList : " + sList.get(index) + ",  list : " + list.get(secIndex).getId());
							wDao.insertWorkInfo(list.get(secIndex));
							wDao.deleteTemp();
							break;
						}
					}
				}
			} else {
				wDao.deleteTemp();
			}
			
			wDao.deleteWorkInfo();
			res.sendRedirect("/OurCommunity/workInfo/list");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String timeStamp(String time) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date(Long.parseLong(time) * 1000);
		String day = format.format(date);
		return day;
	}
}