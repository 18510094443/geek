package com.example.lenovo.geeknews.model.bean.zhihu;

import java.util.List;

public class RiBaoBean {
    /**
     * date : 20190305
     * stories : [{"images":["https://pic4.zhimg.com/v2-114e2999bb784d8fc45b7892b3e81717.jpg"],"type":0,"id":9708237,"ga_prefix":"030518","title":"这个欧洲唯一没有联赛的国家，却曾经逼平了欧洲亚军"},{"images":["https://pic4.zhimg.com/v2-0c7338bc91c4ffd5d563a064ddac973f.jpg"],"type":0,"id":9708541,"ga_prefix":"030515","title":"褚时健去世，历史、时代与命运，一切都尘埃落定了"},{"title":"情景喜剧的中国式落魄史","ga_prefix":"030509","images":["https://pic1.zhimg.com/v2-5fe30e6ed49b56f13ffc6d0d4ee5ac8c.jpg"],"multipic":true,"type":0,"id":9708381},{"images":["https://pic1.zhimg.com/v2-84000515fb250b6dc783698968828be0.jpg"],"type":0,"id":9708516,"ga_prefix":"030508","title":"来，根据恋人的特点进行「精准撒娇」"},{"title":"SpaceX 载人飞船成功首飞，人类载人航天进入新纪元","ga_prefix":"030507","images":["https://pic4.zhimg.com/v2-d3687a2143a3d43b06c886489d53ace7.jpg"],"multipic":true,"type":0,"id":9708485},{"images":["https://pic4.zhimg.com/v2-0c4beec8e8b43a24b8098d11072ebe2b.jpg"],"type":0,"id":9708430,"ga_prefix":"030506","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"https://pic4.zhimg.com/v2-db3673f082f1dbc56cf05da00d209ddf.jpg","type":0,"id":9708541,"ga_prefix":"030515","title":"褚时健去世，历史、时代与命运，一切都尘埃落定了"},{"image":"https://pic1.zhimg.com/v2-b49bb2733f4c2962fce812a4410494a0.jpg","type":0,"id":9708381,"ga_prefix":"030509","title":"情景喜剧的中国式落魄史"},{"image":"https://pic1.zhimg.com/v2-ef9b574a03c14daf75395b7241a62664.jpg","type":0,"id":9708389,"ga_prefix":"030407","title":"世界上最遥远的距离，是你和小米现货的距离"},{"image":"https://pic1.zhimg.com/v2-168b368c1c5a82c94fbf7a275fc2a994.jpg","type":0,"id":9708438,"ga_prefix":"030309","title":"3731 天后，终于又有国人在五大联赛进球了"},{"image":"https://pic3.zhimg.com/v2-8965fe01bb2002ba9ca04bfd2e223482.jpg","type":0,"id":9707662,"ga_prefix":"030408","title":"8 万人在杭州假装自己生活在法兰西"}]
     */

    private String date;
    private List<StoriesBean> stories;
    private List<TopStoriesBean> top_stories;

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

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        /**
         * images : ["https://pic4.zhimg.com/v2-114e2999bb784d8fc45b7892b3e81717.jpg"]
         * type : 0
         * id : 9708237
         * ga_prefix : 030518
         * title : 这个欧洲唯一没有联赛的国家，却曾经逼平了欧洲亚军
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

    public static class TopStoriesBean {
        /**
         * image : https://pic4.zhimg.com/v2-db3673f082f1dbc56cf05da00d209ddf.jpg
         * type : 0
         * id : 9708541
         * ga_prefix : 030515
         * title : 褚时健去世，历史、时代与命运，一切都尘埃落定了
         */

        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

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
    }
}
