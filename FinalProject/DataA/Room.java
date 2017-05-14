package FinalProject.DataA;

//описание структуры базы данных - комнаты

public class Room {
    private long idR;            //идентификатор  - номер по порядку
    private int numberR;         //номер комнаты  или по порядку или
                                 //по шаблону   FN - F-номер этажа N-номер комнаты на этаже
    private String noticeR; //описание комнаты, типа примечание
                                 //кол-во комнат, окна на море, есть ли ванна и т.д.
    private int statusR;       //статус комнаты
                                //-1   удален  (физически ничего не удаляем)
                                //0    номер пустой (по умолчанию)
                                //1    номер забронирован
                                //2    номер заселен
                                //3    ремонт в номере

    public void setStatusR(int statusR) {
        this.statusR = statusR;
    }

    public void setNumberR(int numberR) {
        this.numberR = numberR;
    }

    public void setIdR(long idR) {
        this.idR = idR;
    }

    public Room(long idR, int numberR, String noticeR, int statusR) {
        this.idR = idR;
        this.numberR = numberR;
        this.noticeR = noticeR;
        this.statusR = statusR;
    }

    @Override
    public String toString() {
        return "Room{" +
                "idR=" + idR +
                ", numberR=" + numberR +
                ", noticeR='" + noticeR + '\'' +
                ", statusR=" + statusR +
                '}';
    }

    public long getIdR() {
        return idR;
    }

    public int getNumberR() {
        return numberR;
    }

    public String getNoticeR() {
        return noticeR;
    }

    public int getStatusR() {
        return statusR;
    }
}
