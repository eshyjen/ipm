package com.ericsson.ipm.v1.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;



	@Entity
	@Table(name="MANDATORY_CERTIFICATION")
	@NamedQuery(name="MandatoryCertification.findAll", query="SELECT o FROM MandatoryCertification o")

	public class MandatoryCertification implements Serializable{

		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue
		@Column(name = "ID")
		private int id;

		@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name="userID")
		private UserProfile userprofile;


		@Column(name = "trainingName")
		private String trainingName;

		@Column(name = "dateWeekPlanned")
		private String dateWeekPlanned;

		@Column(name = "dateAttended")
		private String dateAttended;

		@Column(name = "completionStatus")
		private String completionStatus;

		@Column(name = "attachFile")
		private String attachFile;

		/*@Column(name = "FILE_DATA")
	    private byte[] data;*/

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public UserProfile getUserprofile() {
			return userprofile;
		}

		public void setUserprofile(UserProfile userprofile) {
			this.userprofile = userprofile;
		}

		public String getTrainingName() {
			return trainingName;
		}

		public void setTrainingName(String trainingName) {
			this.trainingName = trainingName;
		}

		public String getDateWeekPlanned() {
			return dateWeekPlanned;
		}

		public void setDateWeekPlanned(String dateWeekPlanned) {
			this.dateWeekPlanned = dateWeekPlanned;
		}

		public String getDateAttended() {
			return dateAttended;
		}

		public void setDateAttended(String dateAttended) {
			this.dateAttended = dateAttended;
		}

		public String getCompletionStatus() {
			return completionStatus;
		}

		public void setCompletionStatus(String completionStatus) {
			this.completionStatus = completionStatus;
		}

		public String getAttachFile() {
			return attachFile;
		}

		public void setAttachFile(String attachFile) {
			this.attachFile = attachFile;
		}






}
