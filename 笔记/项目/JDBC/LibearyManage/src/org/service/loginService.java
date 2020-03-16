package org.service;

import java.sql.SQLException;

import org.entity.Loginer;
import org.entity.Student;

public interface loginService {
	public  boolean QueryOne(Loginer loginer,String identity) throws SQLException;
	public  Student getStudentMessage(String id);
}
