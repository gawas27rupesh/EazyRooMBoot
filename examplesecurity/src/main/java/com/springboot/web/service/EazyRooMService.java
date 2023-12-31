package com.springboot.web.service;

import java.util.List;
import java.util.Optional;

import com.springboot.web.entities.Eazy;

public interface EazyRooMService {
	List<Eazy> getUserByCity(String city);

	List<Eazy> getUserByCitygender(String city, String utype, String gender);

	List<Eazy> getUsercount(long contno);

	void CreateAcnt(Eazy eazy);

	void deleteEazy(int eazyId);

	Eazy getEazy(int eazyId);

	List<Eazy> seeyourpost(long contno, int pswd, String utype);

	Eazy showpro(long cd);

	List<Eazy> showAllUser();

	List<Eazy> getAll();

	List<Eazy> getUserByCity(String city, String utype);
}
