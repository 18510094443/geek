package com.example.lenovo.geeknews.model.bean.weixin;

import java.util.List;

public class TabBean {

    /**
     * showapi_res_error :
     * showapi_res_id : d24a993e86a04a838e8972b1e6a996cd
     * showapi_res_code : 0
     * showapi_res_body : {"ret_code":0,"typeList":[{"id":"19","name":"体育迷"},{"id":"2","name":"段子手"},{"id":"3","name":"养生堂"},{"id":"4","name":"私房话"},{"id":"5","name":"八卦精"},{"id":"6","name":"爱生活"},{"id":"7","name":"财经迷"},{"id":"8","name":"汽车迷"},{"id":"9","name":"科技咖"},{"id":"10","name":"潮人帮"},{"id":"11","name":"辣妈帮"},{"id":"12","name":"军事"},{"id":"13","name":"旅行家"},{"id":"14","name":"职场人"},{"id":"15","name":"美食家"},{"id":"16","name":"古今通"},{"id":"17","name":"学霸族"},{"id":"18","name":"星座控"},{"id":"1","name":"热点"}]}
     */

    private String showapi_res_error;
    private String showapi_res_id;
    private int showapi_res_code;
    private ShowapiResBodyBean showapi_res_body;

    public String getShowapi_res_error() {
        return showapi_res_error;
    }

    public void setShowapi_res_error(String showapi_res_error) {
        this.showapi_res_error = showapi_res_error;
    }

    public String getShowapi_res_id() {
        return showapi_res_id;
    }

    public void setShowapi_res_id(String showapi_res_id) {
        this.showapi_res_id = showapi_res_id;
    }

    public int getShowapi_res_code() {
        return showapi_res_code;
    }

    public void setShowapi_res_code(int showapi_res_code) {
        this.showapi_res_code = showapi_res_code;
    }

    public ShowapiResBodyBean getShowapi_res_body() {
        return showapi_res_body;
    }

    public void setShowapi_res_body(ShowapiResBodyBean showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }

    public static class ShowapiResBodyBean {
        /**
         * ret_code : 0
         * typeList : [{"id":"19","name":"体育迷"},{"id":"2","name":"段子手"},{"id":"3","name":"养生堂"},{"id":"4","name":"私房话"},{"id":"5","name":"八卦精"},{"id":"6","name":"爱生活"},{"id":"7","name":"财经迷"},{"id":"8","name":"汽车迷"},{"id":"9","name":"科技咖"},{"id":"10","name":"潮人帮"},{"id":"11","name":"辣妈帮"},{"id":"12","name":"军事"},{"id":"13","name":"旅行家"},{"id":"14","name":"职场人"},{"id":"15","name":"美食家"},{"id":"16","name":"古今通"},{"id":"17","name":"学霸族"},{"id":"18","name":"星座控"},{"id":"1","name":"热点"}]
         */

        private int ret_code;
        private List<TypeListBean> typeList;

        public int getRet_code() {
            return ret_code;
        }

        public void setRet_code(int ret_code) {
            this.ret_code = ret_code;
        }

        public List<TypeListBean> getTypeList() {
            return typeList;
        }

        public void setTypeList(List<TypeListBean> typeList) {
            this.typeList = typeList;
        }

        public static class TypeListBean {
            /**
             * id : 19
             * name : 体育迷
             */

            private String id;
            private String name;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
