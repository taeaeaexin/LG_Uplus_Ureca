package Builder;
//Builder Pattern은 필드가 많아지면 생성자 이슈 발생 <= 객체 생성 시점에 필요한 다양한 생성자를 제공하기 어렵다
//생성자를 통하지 않고 좀 더 효율적으로 객체를 생성할 것인가?

public class Board {
    private String title;
    private String content;
    private String writer;

    //Builder Pattern 적용 전
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle() {
//        this.title = title;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent() {
//        this.content = content;
//    }
//
//    public String getWriter() {
//        return writer;
//    }
//
//    public void setWriter() {
//        this.writer = writer;
//    }
//
//    public Board() {}
//    public Board(String title, String content, String writer) {
//        super();
//        this.title = title;
//        this.content = content;
//        this.writer = writer;
//    }
//
//    @Override
//    public String toString() {
//        return "Board [title=" + title + ", content=" + content + ", writer=" + writer + "]";
//    }
    //특별한 생성자
    private Board(Builder builder) {
        this.title = builder.title;
        this.content = builder.content;
        this.content = builder.writer;
    }

    //필드와 동일한 필드를 가지는 static inner class 생성
    public static class Builder {
        private String title;
        private String content;
        private String writer;

        //method chain 방식으로 필드별 메소드를 생성(이름도 동일하게)
        //setter 대신 필드명을 사용
        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public Builder writer(String writer) {
            this.writer = writer;
            return this;
        }

        //마지막에 호출될 build() 생성 (바깥 클래스 객체를 생성 리턴)
        public Board build() {
            return new Board(this);
        }

        @Override
        public String toString() {
            return "Board [title=" + title + ", content=" + content + ", writer=" + writer + "]";
        }

    }
}