package FinalProject.DataA;

//описание структуры базы данных - пользователь

public class User {
    protected long idU;        //идентификатор  - номер по порядку
    private String nameU;      //наименование пользователя
    private String documentsU; //документы удостоверяющие личность
                                //паспорт или загран паспорт
    private String noticeU;     //иная информация о пользователе
    private int statusU; //статус пользователя
                            //-1   удален  (физически ничего не удаляем)
                            //0    активен (по умолчанию)
                            //1    проблемный


    public void setIdU(long idU) {
        this.idU = idU;
    }

    public void setNameU(String nameU) {
        this.nameU = nameU;
    }

    public void setDocumentsU(String documentsU) {
        this.documentsU = documentsU;
    }

    public void setNoticeU(String noticeU) {
        this.noticeU = noticeU;
    }

    public void setStatusU(int statusU) {
        this.statusU = statusU;
    }

    public User(long idU, String nameU, String documentsU, String noticeU, int statusU) {
        this.idU = idU;
        this.nameU = nameU;
        this.documentsU = documentsU;
        this.noticeU = noticeU;
        this.statusU = statusU;
    }

    public long getIdU() {
        return idU;
    }

    public String getNameU() {
        return nameU;
    }

    public String getDocumentsU() {
        return documentsU;
    }

    public String getNoticeU() {
        return noticeU;
    }

    public int getStatusU() {
        return statusU;
    }

    @Override
    public String toString() {
        return "User{" +
                "idU=" + idU +
                ", nameU='" + nameU + '\'' +
                ", documentsU='" + documentsU + '\'' +
                ", noticeU='" + noticeU + '\'' +
                ", statusU=" + statusU +
                '}';
    }
}
