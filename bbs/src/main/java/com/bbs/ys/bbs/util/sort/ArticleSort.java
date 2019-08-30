package com.bbs.ys.bbs.util.sort;

import com.bbs.ys.bbs.dto.ShowArticle;

import java.util.ArrayList;
import java.util.List;

public class ArticleSort {

    public static List<ShowArticle> articleSort(List<ShowArticle> showArticles){
        List<ShowArticle> hasReply=new ArrayList<>();
        List<ShowArticle> notHasReply = new ArrayList<>();
        for (ShowArticle t:showArticles){
            if (t.getReply_date()==null){
                notHasReply.add(t);
            }else {

                hasReply.add(t);
            }
        }
        hasReply= (List<ShowArticle>) SortListUtil.sort(hasReply,"reply_date",SortListUtil.DESC);
        notHasReply= (List<ShowArticle>) SortListUtil.sort(notHasReply,"article_date",SortListUtil.DESC);

        hasReply.addAll(notHasReply);
        return hasReply;
//        notHasReply.addAll(hasReply);
//        return notHasReply;

    }
}

