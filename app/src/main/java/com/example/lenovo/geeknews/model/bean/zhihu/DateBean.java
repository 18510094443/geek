package com.example.lenovo.geeknews.model.bean.zhihu;

import java.util.List;

public class DateBean {
    /**
     * date : 20190418
     * stories : [{"images":["https://pic2.zhimg.com/v2-771f6cc3313877e934ec2d9619cbb345.jpg"],"type":0,"id":9710391,"ga_prefix":"041822","title":"小事 · 不是因为爱，是还债"},{"images":["https://pic1.zhimg.com/v2-e60b4a6c851ee8e51acc2767d5a1f2b0.jpg"],"type":0,"id":9710307,"ga_prefix":"041819","title":"来，看看这篇给蔡徐坤律师函的「改错」是如何让人尴尬到脸酸"},{"images":["https://pic2.zhimg.com/v2-70a28a330b60289cab767dd914b7af8d.jpg"],"type":0,"id":9710366,"ga_prefix":"041818","title":"巴黎圣母院灾后重建为什么奢侈品公司会买单？"},{"images":["https://pic1.zhimg.com/v2-aa9fb1b1a773f66136e55b26bd23098c.jpg"],"type":0,"id":9710348,"ga_prefix":"041809","title":"《鲁邦三世》原作者加藤一彦去世，它曾在中国热播"},{"images":["https://pic2.zhimg.com/v2-58b5abf70967054a9a057d4f1da8f811.jpg"],"type":0,"id":9710332,"ga_prefix":"041808","title":"死在直播镜头前，她度过了辛苦的一生"},{"title":"华为 P30 Pro 拍的月亮是 PS 的吗？","ga_prefix":"041807","images":["https://pic4.zhimg.com/v2-bb8c0fb5fb4bb6886d2b0e62901a4047.jpg"],"multipic":true,"type":0,"id":9710350},{"images":["https://pic4.zhimg.com/v2-8f86f8617be5f4770b922e5f0baa963f.jpg"],"type":0,"id":9710343,"ga_prefix":"041806","title":"瞎扯 · 如何正确地吐槽"}]
     */

    private String date;
    private List<StoriesBean> stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public static class StoriesBean {
        /**
         * images : ["https://pic2.zhimg.com/v2-771f6cc3313877e934ec2d9619cbb345.jpg"]
         * type : 0
         * id : 9710391
         * ga_prefix : 041822
         * title : 小事 · 不是因为爱，是还债
         * multipic : true
         */

        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private boolean multipic;
        private List<String> images;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isMultipic() {
            return multipic;
        }

        public void setMultipic(boolean multipic) {
            this.multipic = multipic;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }
}
