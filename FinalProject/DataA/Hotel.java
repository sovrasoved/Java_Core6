package FinalProject.DataA;

//описание структуры базы данных - отель

import FinalProject.DataA.City;

public class Hotel {
    private long idH; //идентификатор  - номер по порядку
    private String nameH; //название отеля
    private long edrpouH; //код ЕДРОПУ отеля
    private City cityH;//город - вообще-то есть адрес, но это по заданию
    private String addressH; //юридический адрес
    private String noticeH; //примечание - какая-то другая информация, как доехать, т.д.
    private int statusH; //статус отеля
                            //-1   удален  (физически ничего не удаляем)
                            //0    активен (по умолчанию)
                            //1    ремонт ......

    public void setIdH(long idH) {
        this.idH = idH;
    }

    public void setStatusH(int statusH) {
        this.statusH = statusH;
    }

    public Hotel(long idH, String nameH, long edrpouH, City cityH, String addressH, String noticeH, int statusH) {
        this.idH = idH;
        this.nameH = nameH;
        this.edrpouH = edrpouH;
        this.cityH = cityH;
        this.addressH = addressH;
        this.noticeH = noticeH;
        this.statusH = statusH;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "idH=" + idH +
                ", nameH='" + nameH + '\'' +
                ", edrpouH=" + edrpouH +
                ", cityH=" + cityH +
                ", addressH='" + addressH + '\'' +
                ", noticeH='" + noticeH + '\'' +
                ", statusH=" + statusH +
                "}";
    }

    public long getIdH() {
        return idH;
    }

    public Hotel(String nameH, long edrpouH, City cityH, String addressH, String noticeH, int statusH) {
        this.nameH = nameH;
        this.edrpouH = edrpouH;
        this.cityH = cityH;
        this.addressH = addressH;
        this.noticeH = noticeH;
        this.statusH = statusH;
    }

    public String getNameH() {
        return nameH;
    }

    public long getEdrpouH() {
        return edrpouH;
    }

    public City getCityH() {
        return cityH;
    }

    public String getAddressH() {
        return addressH;
    }

    public String getNoticeH() {
        return noticeH;
    }

    public int getStatusH() {
        return statusH;
    }
}
