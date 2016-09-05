namespace java com.gemantic.analyse.thrift.index

struct  NewsModel{
1:i32 id ;
2:string title;
3:string content;
4:string media_from;
5:string author;
}

service IndexNewsOperatorServices {
bool indexNews(1:NewsModel indexNews),
bool deleteArtificiallyNews(1:i32 id )
}
