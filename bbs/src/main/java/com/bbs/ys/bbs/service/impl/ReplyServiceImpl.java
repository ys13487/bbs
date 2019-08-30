package com.bbs.ys.bbs.service.impl;

import com.bbs.ys.bbs.dao.ReplyDao;
import com.bbs.ys.bbs.empty.Article;
import com.bbs.ys.bbs.empty.Reply;
import com.bbs.ys.bbs.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService { @Autowired
ReplyDao replyDao;

    @Override
//    @Cacheable(value="selectAllReplyByArticleID-key")
    public List<Reply> selectAllReplyByArticleID(int article_id) {
        return replyDao.selectAllReplyByArticleID(article_id);
    }

    @Override
    public List<Reply> selectAllReply(int article_id, int replypage) {
        return replyDao.selectAllReply(article_id,replypage);
    }

    @Override
    public void addReply(int article_id, String replyer, Date date, String reply) {
        replyDao.addReply(article_id,replyer,date,reply);
    }

    @Override
    public void deleteReply(int id) {
        replyDao.deleteReply(id);
    }

}
