package com.example.king.yangmingsen20190102.beans;

public class PrudentBean {

    private String msg;
    private String code;
    private Data data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public class Data {
        private String bargainPrice;
        private String createtime;
        private String detailUrl;
        private String images;
        private String itemtype;
        private String pid;
        private String price;
        private String pscid;
        private String salenum;
        private String sellerid;
        private String subhead;
        private String title;

        public String getBargainPrice() {
            return bargainPrice;
        }

        public void setBargainPrice(String bargainPrice) {
            this.bargainPrice = bargainPrice;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getDetailUrl() {
            return detailUrl;
        }

        public void setDetailUrl(String detailUrl) {
            this.detailUrl = detailUrl;
        }

        public String getImages() {
            return images;
        }

        public void setImages(String images) {
            this.images = images;
        }

        public String getItemtype() {
            return itemtype;
        }

        public void setItemtype(String itemtype) {
            this.itemtype = itemtype;
        }

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getPscid() {
            return pscid;
        }

        public void setPscid(String pscid) {
            this.pscid = pscid;
        }

        public String getSalenum() {
            return salenum;
        }

        public void setSalenum(String salenum) {
            this.salenum = salenum;
        }

        public String getSellerid() {
            return sellerid;
        }

        public void setSellerid(String sellerid) {
            this.sellerid = sellerid;
        }

        public String getSubhead() {
            return subhead;
        }

        public void setSubhead(String subhead) {
            this.subhead = subhead;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

}
