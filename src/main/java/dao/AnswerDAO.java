package dao;

import controllers.ConnectionPool;
import entity.Answer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AnswerDAO extends AbstractDAO<Answer, Long> {


    @Override
    public void add(Answer entity) {

    }

    @Override
    public Answer get(Long id) {
        return null;
    }

    @Override
    public List<Answer> getAll() {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
