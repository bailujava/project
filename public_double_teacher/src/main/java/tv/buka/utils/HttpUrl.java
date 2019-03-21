package tv.buka.utils;

public enum HttpUrl {
    URL{
        public String geturl(){
           // return "https://a.buka.tv/buka/api";
            return "http://test-a.buka.tv/buka/api";
        }
    },
    GET_IP{
        public String geturl(){
            return "http://a.buka.tv/base/common/upload/";
        }
    },
    URL_VIDEO{
        public String geturl(){
            //return "http://a.buka.tv/buka/signaling/data";
            return "http://test-a.buka.tv/buka/signaling/data";
        }
    },
    USER_CENTER{
        public String geturl() {
            //return "http://a.buka.tv/base/usercenter";
            return "http://test-a.buka.tv/base/usercenter";
        }
    },/*
    VIDEO_CIPHER{
        public String geturl(){
            return "&tag=media&organization_cipher="+HttpUrl.ORGANIZATION_CIPHER.geturl();
        }
    },*/
    ORGANIZATION_CIPHER{
        public String geturl(){return "86441b763d4c8071920bea3122e37da5";}
    },
    KEY{
        public String geturl(){
            return "K4BGzO8O8AJ79zh4l7Sxw2f810510e1p";
        }
    },
    MODEL_ID{
        public String geturl(){
            return "2";
        }
    };
    public abstract String geturl();
}