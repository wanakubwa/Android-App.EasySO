package pl.io.quizapi.dao.dtos;


public class AnswerDTO {
    private Integer uid;
    private String answer;
    private Boolean result;

    public AnswerDTO() {
    }

    public AnswerDTO(String answer, Boolean result) {
        this.answer = answer;
        this.result = result;
    }

    public AnswerDTO(Integer uid, String answer, Boolean result) {
        this.answer = answer;
        this.result = result;
        this.uid = uid;
    }

    public String getAnswer() {
        return answer;
    }

    public Integer getUid() {
        return uid;
    }

    public Boolean getResult() {
        return result;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}
