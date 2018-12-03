package com.utunan.pojo.base.questionbank;

import com.utunan.pojo.base.user.User;

public class Question {
    //题库列表ID
    private Long questionId;
    private Subject subject;



    //章节
    private String chapterName;
    //录入人
    private User User;
    //题目类型
    private String questionType;
    //题干内容
    private String questionContent;
    //选项A
    private String optionA;
    //选项B
    private String optionB;
    //选项C
    private String optionC;
    //选项D
    private String optionD;
    //正确答案
    private String questionAnswer;
    //解析
    private String questionAnalyse;
    //录入时间
    private String questionEnterTime;


    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", subject=" + subject +
                ", chapterName='" + chapterName + '\'' +
                ", User=" + User +
                ", questionType='" + questionType + '\'' +
                ", questionContent='" + questionContent + '\'' +
                ", optionA='" + optionA + '\'' +
                ", optionB='" + optionB + '\'' +
                ", optionC='" + optionC + '\'' +
                ", optionD='" + optionD + '\'' +
                ", questionAnswer='" + questionAnswer + '\'' +
                ", questionAnalyse='" + questionAnalyse + '\'' +
                ", questionEnterTime='" + questionEnterTime + '\'' +
                '}';
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public com.utunan.pojo.base.user.User getUser() {
        return User;
    }

    public void setUser(com.utunan.pojo.base.user.User user) {
        User = user;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public String getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(String questionAnswer) {
        this.questionAnswer = questionAnswer;
    }

    public String getQuestionAnalyse() {
        return questionAnalyse;
    }

    public void setQuestionAnalyse(String questionAnalyse) {
        this.questionAnalyse = questionAnalyse;
    }

    public String getQuestionEnterTime() {
        return questionEnterTime;
    }

    public void setQuestionEnterTime(String questionEnterTime) {
        this.questionEnterTime = questionEnterTime;
    }

}
