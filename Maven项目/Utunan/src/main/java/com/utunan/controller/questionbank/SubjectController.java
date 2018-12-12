package com.utunan.controller.questionbank;

import com.github.pagehelper.PageInfo;
import com.utunan.pojo.base.questionbank.Question;
import com.utunan.pojo.base.questionbank.Subject;
import com.utunan.pojo.base.user.User;
import com.utunan.pojo.inherit.questionbank.SubjectCount;
import com.utunan.service.questionbank.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 孙程程
 * @description: TODO
 * @date 2018/12/4 15:46
 */
@Controller
public class SubjectController {
	@Autowired
	private SubjectService subjectService;

	/**
	 * @author  孙程程
	 * @description 专项练习科目
	 * @date  15:50 2018/12/4
	 * @param  request
	 * @return  java.lang.String
	 */
	@RequestMapping("/subjects")
	public String subject(HttpServletRequest request){
		User user=(User) request.getSession().getAttribute("User");
		String userId="0";
		//判断用户是否登录
		if (user==null){
			userId="0";
		}
		else {
			userId=user.getUserId().toString();
		}
		//科目列表
		List<Subject> subjectList=this.subjectService.listSubject();
		//科目ID
		List<Long> subjectIdList=new ArrayList<>();
		for(int i=0; i<subjectList.size(); i++){
			subjectIdList.add(subjectList.get(i).getSubjectId());
		}
		//科目下题目数量
		List<Long> questionNumber=new ArrayList<>();
		//科目下已做题目数量
		List<Long> resolveQuestionNumber=new ArrayList<>();
		for(int i=0; i<subjectList.size(); i++){
			questionNumber.add(subjectService.countQuestionBySubject(subjectIdList.get(i)));
			resolveQuestionNumber.add(subjectService.countResolveQuestionBySubject(subjectIdList.get(i),Long.parseLong(userId)));
		}
		//SubjectCount类
		List<SubjectCount> subjectCountList=new ArrayList<>();
		for(int i=0; i<subjectList.size(); i++){
			SubjectCount sc=new SubjectCount();
			sc.setSubject(subjectList.get(i));
			sc.setAllQuestionNumber(questionNumber.get(i));
			sc.setResolveQuestionNumber(resolveQuestionNumber.get(i));
			subjectCountList.add(sc);
		}
		//返回数据
		request.setAttribute("subject",subjectCountList);
		return "questionbank/subject";
	}

	/**
	 * @author  孙程程
	 * @description 专项练习题目列表
	 * @date  15:22 2018/12/5
	 * @param  request
	 * @return  java.lang.String
	 */
	@RequestMapping("subject")
	public String subjectQuestion(HttpServletRequest request){
		String pageNum=request.getParameter("pageNum");
		//判断当前页
		int num=0;
		if(pageNum==null || pageNum.equals("")){
			num=1;
		}else{
			num=Integer.parseInt(pageNum);
		}
		User user=(User) request.getSession().getAttribute("User");
		String userId="0";
		//判断用户是否登录
		if (user==null){
			userId="0";
		}
		else {
			userId=user.getUserId().toString();
		}
		String subjectName=request.getParameter("subjectName");
		//题目列表
		List<Question> questionList=subjectService.listQuestionBySubject(subjectName, num, 12);
		//科目ID
		Long subjectId=subjectService.findSubjectIdByName(subjectName);
		//已解答题目数量
		Long resolveQuestionNumber=subjectService.countResolveQuestionBySubject(subjectId,Long.parseLong(userId));
		//返回数据
		request.setAttribute("url", "subject");
		request.setAttribute("subjectName", subjectName);
		request.setAttribute("questionList", questionList);
		request.setAttribute("resolveQuestionNumber", resolveQuestionNumber);
		request.setAttribute("PageInfo",new PageInfo(questionList,5));
		return "questionbank/subjectquestion";
	}
}
