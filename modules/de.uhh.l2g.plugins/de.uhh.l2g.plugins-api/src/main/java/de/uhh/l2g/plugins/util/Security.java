package de.uhh.l2g.plugins.util;

/***************************************************************************
 * The Lecture2Go software is based on the liferay portal 6.1.1 
 * <http://www.liferay.com>
 * 
 * Lecture2Go <http://lecture2go.uni-hamburg.de> is an open source 
 * platform for media management and distribution. Our goal is to 
 * support the free access to knowledge because this is a component 
 * of each democratic society. The open source software is aimed at 
 * academic institutions and has to strengthen the blended learning.
 * 
 * All Lecture2Go plugins are continuously being developed and improved.
 * For more details please visit <http://lecture2go-open-source.rrz.uni-hamburg.de>
 * 
 * @Autor Lecture2Go Team
 * @Version 1.0
 * @Contact lecture2go-open-source@uni-hamburg.de
 *  
 * Copyright (c) 2013 University of Hamburg / Computer and Data Center (RRZ)
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>. 
 ***************************************************************************/

import java.math.BigInteger;
import java.util.Base64;

/**
 * The Class Security.
 */
public class Security {

	/** The tomcat l2 go video repository. */
	private String tomcatL2GoVideoRepository = "";

	/**
	 * Gets the tomcat l2 go video repository.
	 *
	 * @return the tomcat l2 go video repository
	 */
	public String getTomcatL2GoVideoRepository() {
		return tomcatL2GoVideoRepository;
	}

	/**
	 * Sets the tomcat l2 go video repository.
	 *
	 * @param tomcatL2GoVideoRepository the new tomcat l2 go video repository
	 */
	public void setTomcatL2GoVideoRepository(String tomcatL2GoVideoRepository) {
		this.tomcatL2GoVideoRepository = tomcatL2GoVideoRepository;
	}

	/** The fms l2 go video repository. */
	private String fmsL2GoVideoRepository = "";

	/**
	 * Gets the fms l2 go video repository.
	 *
	 * @return the fms l2 go video repository
	 */
	public String getFmsL2GoVideoRepository() {
		return fmsL2GoVideoRepository;
	}

	/**
	 * Sets the fms l2 go video repository.
	 *
	 * @param fmsL2GoVideoRepository the new fms l2 go video repository
	 */
	public void setFmsL2GoVideoRepository(String fmsL2GoVideoRepository) {
		this.fmsL2GoVideoRepository = fmsL2GoVideoRepository;
	}

	/**
	 * Creates the secure symbolic link for tomcat l2 go repository.
	 *
	 * @param pfad the pfad
	 * @param filenamePreffix the filename preffix
	 * @param filenameFormat the filename format
	 * @throws Exception the exception
	 */
	public void createSecureSymbolicLinkForTomcatL2GoRepository(String pfad, String filenamePreffix, String filenameFormat) throws Exception {
		String secureFilename = createSecureFileName();
		Runtime runCmd = Runtime.getRuntime();
		String command = "ln -s " + pfad + "/" + filenamePreffix + "." + filenameFormat + " " + tomcatL2GoVideoRepository + "/" + secureFilename + "." + filenameFormat;
		runCmd.exec(command);
	}

	/**
	 * Creates the secure hard link for fms l2 go repository.
	 *
	 * @param pfad the pfad
	 * @param filenamePreffix the filename preffix
	 * @param filenameFormat the filename format
	 * @throws Exception the exception
	 */
	public void createSecureHardLinkForFmsL2GoRepository(String pfad, String filenamePreffix, String filenameFormat) throws Exception {
		String secureFilename = createSecureFileName();
		Runtime runCmd = Runtime.getRuntime();
		String command = "ln " + pfad + "/" + filenamePreffix + "." + filenameFormat + " " + fmsL2GoVideoRepository + "/" + secureFilename + "." + filenameFormat;
		runCmd.exec(command);
	}

	/**
	 * Creates the secure file name.
	 *
	 * @return the string
	 */
	public static String createSecureFileName() {
		BaseX baseX = new BaseX();
		BigInteger mseC = BigInteger.valueOf(System.currentTimeMillis());
		String ret = baseX.encode(mseC).toString();
		return ret;
	}

	/**
	 * Encode string.
	 *
	 * @param p_sString the p_s string
	 * @return the string
	 */
	public static String encodeString(String p_sString) {
		if (p_sString == null) return "";
		String encoded = Base64.getEncoder().encodeToString(p_sString.getBytes());
		return (encoded);
	}

	/**
	 * Decode string.
	 *
	 * @param p_sString the p_s string
	 * @return the string
	 */
	public static String decodeString(String p_sString) {
		if (p_sString == null || p_sString.equals("")) return null;
		byte[] decoded = Base64.getDecoder().decode(p_sString);
		return new String(decoded.toString());
	}

}
