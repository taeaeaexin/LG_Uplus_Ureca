//package dao;
//
//import static com.mongodb.client.model.Filters.eq;
//import static com.mongodb.client.model.Updates.set;
//import static com.mongodb.client.model.Updates.combine;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.bson.Document;
//import org.bson.conversions.Bson;
//
//import com.mongodb.client.MongoClient;
//import com.mongodb.client.MongoClients;
//import com.mongodb.client.MongoCollection;
//import com.mongodb.client.MongoDatabase;
//
//// jdbc 처럼
//public class BookDao {
//
//    static final String CONNECTION_STRING = "mongodb://localhost:27017";
//    static final String DATABASE_NAME = "madang";
//    static final String COLLECTION_NAME = "book";
//    // username, password 필요 X
//
//    private MongoClient mongoClient;  // jdbc Connection 유사
//    private MongoDatabase database;
//    private MongoCollection<Document> collection;
//
//    // 생성자 mongodb 연결 초기화
//    public BookDao() {
//        try {
//            this.mongoClient = MongoClients.create(CONNECTION_STRING);
//            this.database = this.mongoClient.getDatabase(DATABASE_NAME);
//            this.collection = database.getCollection(COLLECTION_NAME);
//        }catch(Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public List<BookDto> listBook(){
//        List<BookDto> bookList = new ArrayList<>();
//
//        for (Document doc : collection.find()) {
//            BookDto bookDto = new BookDto();
//            bookDto.setBookId(doc.getInteger("bookid"));
//            bookDto.setBookName(doc.getString("bookname"));
//            bookDto.setPublisher(doc.getString("publisher"));
//            bookDto.setPrice(doc.getInteger("price"));
//            bookList.add(bookDto);
//        }
//
//        return bookList;
//    }
//
//    public List<BookDto> listBookSearch(String searchWord){
//
//        List<BookDto> bookList = new ArrayList<>();
////		Document filterDocument = new Document("$regex", searchWord).append("$option", "i");
//        Document bookNameFilter = new Document("bookname", new Document("$regex", searchWord));
//
//        for (Document doc : collection.find(bookNameFilter)) {
//            BookDto bookDto = new BookDto();
//            bookDto.setBookId(doc.getInteger("bookid"));
//            bookDto.setBookName(doc.getString("bookname"));
//            bookDto.setPublisher(doc.getString("publisher"));
//            bookDto.setPrice(doc.getInteger("price"));
//            bookList.add(bookDto);
//        }
//
//        return bookList;
//    }
//
//    public BookDto detailBook(int bookid) {
//        Document doc = collection.find( eq("bookid", bookid) ).first();
//        BookDto bookDto = null;
//        if( doc != null ) {
//            bookDto = new BookDto();
//            bookDto.setBookId(doc.getInteger("bookid"));
//            bookDto.setBookName(doc.getString("bookname"));
//            bookDto.setPublisher(doc.getString("publisher"));
//            bookDto.setPrice(doc.getInteger("price"));
//
//        }
//        return bookDto;
//    }
//
//    public void insertBook(BookDto bookDto) {
//        Document document = new Document("bookid", bookDto.getBookId())
//                .append("bookname", bookDto.getBookName())
//                .append("publisher", bookDto.getPublisher())
//                .append("price", bookDto.getPrice());
//        collection.insertOne(document);
//    }
//
//    public void updateBook(BookDto bookDto) {
//        Bson filter = eq("bookid", bookDto.getBookId());
//        Bson update = combine(
//                set("bookname", bookDto.getBookName()),
//                set("publisher", bookDto.getPublisher()),
//                set("price", bookDto.getPrice())
//        );
//        collection.updateOne(filter, update);
//    }
//
//    public void deleteBook(int bookid) {
//        collection.deleteOne( eq("bookid", bookid) );
//    }
//}