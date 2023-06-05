package com.frame.business.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.frame.business.entity.EmpImageFile;
import com.frame.business.entity.Employee;
import com.frame.business.entity.EmployeePositionFulfillment;
import com.frame.business.entity.EmployeeQual;
import com.frame.business.entity.EmployeeSkill;
import com.frame.business.entity.Status;
import com.frame.dao.EmpImageFileDao;
import com.frame.dao.EmployeeDao;
import com.frame.dao.EmployeeExpDao;
import com.frame.dao.EmployeeQualDao;
import com.frame.dao.EmployeeSkillDao;
import com.frame.dao.StatusDao;
import com.frame.presentation.form.AdminForm;
import com.frame.presentation.form.EmployeeForm;
import com.frame.presentation.form.EmployeeViewProfileForm;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * 
 * @author Yuzana Zaw Zaw
 */
public class EmployeeService {
	private EmployeeDao myEmployeeDao;
	private EmployeeExpDao myEmployeeExpDao;
	private StatusDao myStatusDao;

	public StatusDao getMyStatusDao() {
		return myStatusDao;
	}

	public void setMyStatusDao(StatusDao myStatusDao) {
		this.myStatusDao = myStatusDao;
	}

	public EmployeeExpDao getMyEmployeeExpDao() {
		return myEmployeeExpDao;
	}

	public void setMyEmployeeExpDao(EmployeeExpDao myEmployeeExpDao) {
		this.myEmployeeExpDao = myEmployeeExpDao;
	}

	public EmployeeQualDao getMyEmployeeQualDao() {
		return myEmployeeQualDao;
	}

	public void setMyEmployeeQualDao(EmployeeQualDao myEmployeeQualDao) {
		this.myEmployeeQualDao = myEmployeeQualDao;
	}

	public EmployeeSkillDao getMyEmployeeSkillDao() {
		return myEmployeeSkillDao;
	}

	public void setMyEmployeeSkillDao(EmployeeSkillDao myEmployeeSkillDao) {
		this.myEmployeeSkillDao = myEmployeeSkillDao;
	}

	private EmployeeQualDao myEmployeeQualDao;
	private EmployeeSkillDao myEmployeeSkillDao;

	private EmpImageFileDao myEmpImageFileDao;

	public EmployeeDao getMyEmployeeDao() {
		return myEmployeeDao;
	}

	public void setMyEmployeeDao(EmployeeDao myEmployeeDao) {
		this.myEmployeeDao = myEmployeeDao;
	}

	public EmpImageFileDao getMyEmpImageFileDao() {
		return myEmpImageFileDao;
	}

	public void setMyEmpImageFileDao(EmpImageFileDao myEmpImageFileDao) {
		this.myEmpImageFileDao = myEmpImageFileDao;
	}

	public EmployeeDao getmyEmployeeDao() {
		return myEmployeeDao;
	}

	public void setmyEmployeeDao(EmployeeDao myEmployeeDao) {
		this.myEmployeeDao = myEmployeeDao;
	}

	public Employee saveNewEmployee(EmployeeForm myForm) {
		Employee myEmployee = new Employee();
		myEmployee.setId(null);
		myEmployee.setFirstName(myForm.getFrmFirstName());
		myEmployee.setLastName(myForm.getFrmLastName());
		myEmployee.setEmail(myForm.getFrmEmail());
		myEmployee.setPassword(myForm.getFrmPassword());
		myEmployee.setPhoneNo(myForm.getFrmPhone());
		myEmployee.setNrc(myForm.getFrmNrc());
		myEmployee.setGender(myForm.getFrmGender());
		myEmployee.setAddress(myForm.getFrmAddress());
		myEmployee.setSecurityQest(myForm.getFrmSecurityQuest());
		Status status = myStatusDao.searchStatusByStatusName("ACTIVE");
		myEmployee.setStatus(status);
		myEmployee.setFatherName(myForm.getFrmFatherName());
		SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
		Date birthDate;
		try {
			if (!myForm.getFrmBirthDate().equals("")
					|| myForm.getFrmBirthDate() != null) {
				birthDate = myformat.parse(myForm.getFrmBirthDate());
				java.sql.Date birth_date = new java.sql.Date(
						birthDate.getTime());
				myEmployee.setBirthDate(birth_date);
			}
			myEmployeeDao.saveEmployee(myEmployee);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myEmployee;
	}

	public void firstLoadRegistration(EmployeeForm myForm) {
		myForm.setFrmUploadImage(null);
		myForm.setFrmFirstName("");
		myForm.setFrmLastName("");
		myForm.setFrmFatherName("");
		myForm.setFrmEmail("");
		myForm.setFrmPassword("");
		myForm.setFrmPhone("");
		myForm.setFrmNrc("");
		myForm.setFrmGender("");
		myForm.setFrmAddress("");
		myForm.setFrmSecurityQuest("");
		myForm.setFrmBirthDate(null);
		myForm.setFrmRegFormControl(null);
	}

	public void checkEmail(EmployeeForm myForm) {
		Employee myEmployee = myEmployeeDao.getEmployeeByEmail(myForm
				.getFrmEmail());
		if (myEmployee != null) {
			myForm.setFrmEmailError("error");
			myForm.setFrmRegFormControl(null);
		} else {
			myForm.setFrmEmailError("data");
			myForm.setFrmRegFormControl("data");
		}
	}

	public void checkLoginUser(EmployeeForm myForm) {
		Employee myEmployee = myEmployeeDao.getEmployeeByEmailAndPassword(
				myForm.getFrmLoginEmail(), myForm.getFrmLoginPassword());
		myForm.setLoginUser(myEmployee);
	}

	public void verifySecurityQuestion(EmployeeForm myForm) {
		Employee myEmployee = myEmployeeDao.getEmployeeByEmailAndSecurityQ(
				myForm.getFrmForgetPassEmail(),
				myForm.getFrmForgetPassSecurityQuest());
		myForm.setLoginUser(myEmployee);

	}

	public boolean checkLoginUser(String email, String frmChangeOldPassword) {
		Employee myEmployee = myEmployeeDao.getEmployeeByEmailAndPassword(
				email, frmChangeOldPassword);
		if (myEmployee == null) {
			return false;
		} else {
			return true;
		}
	}

	public void saveUpdateEmployeePass(EmployeeForm myForm) {
		Employee myEmployee = myForm.getLoginUser();
		myEmployee.setPassword(myForm.getFrmChangeConfirmPassword());
		myEmployeeDao.saveUpdateEmployeePass(myEmployee);
		myForm.setFrmChangeOldPassword("");
		myForm.setFrmChangeNewPassword("");
		myForm.setFrmChangeConfirmPassword("");
	}

	public void firstLoadUpdateProfile(EmployeeForm myForm) {
		Employee myLoginUser = myForm.getLoginUser();
		myForm.setFrmFirstName(myLoginUser.getFirstName());
		myForm.setFrmLastName(myLoginUser.getLastName());
		myForm.setFrmEmail(myLoginUser.getEmail());
		myForm.setFrmPassword(myForm.getFrmPassword());
		myForm.setFrmPhone(myLoginUser.getPhoneNo());
		myForm.setFrmFatherName(myLoginUser.getFatherName());
		myForm.setFrmNrc(myLoginUser.getNrc());
		myForm.setFrmGender(myLoginUser.getGender());
		myForm.setFrmAddress(myLoginUser.getAddress());
		if (myLoginUser.getBirthDate() != null) {
			SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = myLoginUser.getBirthDate();
			java.sql.Date birth_date = new java.sql.Date(date.getTime());
			myForm.setFrmBirthDate(myformat.format(birth_date));
		}
	}

	public void saveUpdateEmployee(EmployeeForm myForm) {
		Employee myEmployee = myForm.getLoginUser();
		myEmployee.setFirstName(myForm.getFrmFirstName());
		myEmployee.setLastName(myForm.getFrmLastName());
		myEmployee.setPhoneNo(myForm.getFrmPhone());
		myEmployee.setFatherName(myForm.getFrmFatherName());
		myEmployee.setGender(myForm.getFrmGender());
		myEmployee.setAddress(myForm.getFrmAddress());
		myEmployee.setSecurityQest(myForm.getFrmSecurityQuest());
		SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
		Date birthDate;
		try {
			if (myForm.getFrmBirthDate() != null) {
				birthDate = myformat.parse(myForm.getFrmBirthDate());
				java.sql.Date birth_date = new java.sql.Date(
						birthDate.getTime());
				myEmployee.setBirthDate(birth_date);
			}
			myEmployeeDao.saveEmployee(myEmployee);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void viewProfileByLoginUser(EmployeeViewProfileForm myForm,
			EmployeeForm loginForm) {
		myForm.setFrmEmployee(loginForm.getLoginUser());
		List<EmployeePositionFulfillment> experienceList = myEmployeeExpDao
				.getEmployeeExpListAll(loginForm.getLoginUser());
		List<EmployeeQual> qualList = myEmployeeQualDao
				.getEmployeeQualListAll(loginForm.getLoginUser());
		List<EmployeeSkill> skillList = myEmployeeSkillDao
				.getEmployeeSkillListAll((loginForm.getLoginUser()));
		EmployeePositionFulfillment currentPosition = myEmployeeExpDao
				.getCurrentPositionByLoginUser(loginForm.getLoginUser());
		if (currentPosition != null) {
			myForm.setFrmCurrentPosition(currentPosition.getId()
					.getPartyGroupPosition().getPositionName());
		} else {
			myForm.setFrmCurrentPosition("");
		}
		if (experienceList != null) {
			myForm.setFrmExperinenceList(experienceList);
		} else {
			myForm.setFrmExperinenceList(null);
		}
		if (qualList != null) {
			myForm.setFrmQualTypeList(qualList);
		} else {
			myForm.setFrmQualTypeList(null);
		}
		if (skillList != null) {
			myForm.setFrmSkillList(skillList);
		} else {
			myForm.setFrmSkillList(null);
		}

	}

	public void viewProfileByEmployeeId(EmployeeViewProfileForm myForm,
			int frmEmployeeId) {
		Employee employee = myEmployeeDao.getEmployeeById(frmEmployeeId);
		myForm.setFrmEmployee(employee);
		List<EmployeePositionFulfillment> experienceList = myEmployeeExpDao
				.getEmployeeExpListAll(employee);
		List<EmployeeQual> qualList = myEmployeeQualDao
				.getEmployeeQualListAll(employee);
		List<EmployeeSkill> skillList = myEmployeeSkillDao
				.getEmployeeSkillListAll(employee);
		EmployeePositionFulfillment currentPosition = myEmployeeExpDao
				.getCurrentPositionByLoginUser(employee);
		if (currentPosition != null) {
			myForm.setFrmCurrentPosition(currentPosition.getId()
					.getPartyGroupPosition().getPositionName());
		} else {
			myForm.setFrmCurrentPosition("");
		}
		myForm.setFrmExperinenceList(experienceList);
		myForm.setFrmQualTypeList(qualList);
		myForm.setFrmSkillList(skillList);

	}

	public void employeeCVDownload(EmployeeViewProfileForm myForm,
			String FILE_NAME, String IMAGE_FILE_NAME) {
		Employee employee = myEmployeeDao.getEmployeeById(myForm
				.getFrmEmployeeId());
		List<EmployeePositionFulfillment> experienceList = myEmployeeExpDao
				.getEmployeeExpListAll(employee);
		List<EmployeeQual> qualList = myEmployeeQualDao
				.getEmployeeQualListAll(employee);
		List<EmployeeSkill> skillList = myEmployeeSkillDao
				.getEmployeeSkillListAll(employee);
		EmployeePositionFulfillment currentPosition = myEmployeeExpDao
				.getCurrentPositionByLoginUser(employee);

		Document document = new Document();

		try {

			PdfWriter.getInstance(document, new FileOutputStream(FILE_NAME
					+ employee.getFirstName() + employee.getLastName() + "_"
					+ "CVForm" + ".pdf"));
			// open
			document.open();

			// ----------------------------------------Header-------------------------------------
			Font titleF = new Font();
			titleF.setSize(14);

			Paragraph title = new Paragraph("CURRICULUM VITAE", titleF);
			title.setAlignment(Element.ALIGN_CENTER);
			document.add(title);
			
			Paragraph line1 = new Paragraph();
			line1.add("                                                           ");
			line1.setAlignment(Element.ALIGN_CENTER);
			document.add(line1);

			// ------------------------setting for profile
			// image------------------------------------
			if (!IMAGE_FILE_NAME.equals("")||IMAGE_FILE_NAME!=null) {
				Paragraph pImage = new Paragraph();
				// Add Image
				Image image1 = Image.getInstance(IMAGE_FILE_NAME);
				image1.scaleAbsolute(150, 170);
				image1.setAlignment(Element.ALIGN_RIGHT);
				image1.setAlt("Profile Image");
				pImage.add(image1);
				// Add to document
				document.add(pImage);
			}
			// ----------------------------------------Employee
			// Profile---------------------------
			Paragraph pName = new Paragraph();
			pName.add("Name					: ");
			pName.add(employee.getFirstName() + " " + employee.getLastName());
			pName.setAlignment(Element.ALIGN_MIDDLE);
			document.add(pName);
			if (currentPosition != null) {
				Paragraph pCurrentPosition = new Paragraph();
				pCurrentPosition.add("Current Position					: ");
				pCurrentPosition.add(currentPosition.getId()
						.getPartyGroupPosition().getPositionName());
				pCurrentPosition.setAlignment(Element.ALIGN_JUSTIFIED);
				document.add(pCurrentPosition);
			}
			Paragraph pFatherName = new Paragraph();
			pFatherName.add("Father Name	: ");
			pFatherName.add(employee.getFatherName());
			pFatherName.setAlignment(Element.ALIGN_JUSTIFIED);
			document.add(pFatherName);

			Paragraph pNrc = new Paragraph();
			pNrc.add("Nrc					: ");
			pNrc.add(employee.getNrc());
			pNrc.setAlignment(Element.ALIGN_JUSTIFIED);
			document.add(pNrc);

			SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = employee.getBirthDate();
			java.sql.Date birth_date = new java.sql.Date(date.getTime());

			Paragraph pBirth = new Paragraph();
			pBirth.add("Birth Date			: ");
			pBirth.add(myformat.format(birth_date));
			pBirth.setAlignment(Element.ALIGN_JUSTIFIED);
			document.add(pBirth);

			Paragraph pGender = new Paragraph();
			pGender.add("Gender			: ");
			pGender.add(employee.getGender());
			pGender.setAlignment(Element.ALIGN_JUSTIFIED);
			document.add(pGender);

			Paragraph pEmail = new Paragraph();
			pEmail.add("Email				: ");
			pEmail.add(employee.getEmail());
			pEmail.setAlignment(Element.ALIGN_JUSTIFIED);
			document.add(pEmail);

			Paragraph pPhone = new Paragraph();
			pPhone.add("Phone no			: ");
			pPhone.add(employee.getPhoneNo());
			pPhone.setAlignment(Element.ALIGN_JUSTIFIED);
			document.add(pPhone);

			Paragraph pAddress = new Paragraph();
			pAddress.add("Address			: ");
			pAddress.add(employee.getAddress());
			pAddress.setAlignment(Element.ALIGN_JUSTIFIED);
			document.add(pAddress);

			// -------------------------Setting Employee
			// Skill---------------------------
			if (skillList != null) {
				Paragraph space1 = new Paragraph();
				space1.add("                                                           ");
				space1.setAlignment(Element.ALIGN_CENTER);
				document.add(space1);
				
				Paragraph line = new Paragraph();
				line.add("Skills");
				line.setAlignment(Element.ALIGN_CENTER);
				document.add(line);
				
				Paragraph space2 = new Paragraph();
				space2.add("                                                           ");
				space2.setAlignment(Element.ALIGN_CENTER);
				document.add(space2);
				
				PdfPTable skilTable = new PdfPTable(2);
				PdfPCell c1 = new PdfPCell(new Phrase("Skill Name"));
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				skilTable.addCell(c1);

				PdfPCell c2 = new PdfPCell(new Phrase("SkillLevel"));
				c2.setHorizontalAlignment(Element.ALIGN_CENTER);
				skilTable.addCell(c2);
				skilTable.setHeaderRows(1);

				for (EmployeeSkill skill : skillList) {
					if (!skill.getId().getSkillType().getDescription()
							.equals("")) {
						skilTable.addCell(skill.getId().getSkillType()
								.getDescription());
					} else {
						skilTable.addCell("-");
					}
					if (!skill.getSkillLevel().equals("")) {
						skilTable.addCell(skill.getSkillLevel());
					} else {
						skilTable.addCell("-");
					}

				}
				document.add(skilTable);

			}
			// -------------------------Setting Employee
			// Qualification---------------------------
			if (qualList != null) {
				Paragraph space1 = new Paragraph();
				space1.add("                                                           ");
				space1.setAlignment(Element.ALIGN_CENTER);
				document.add(space1); 
				
				Paragraph line2 = new Paragraph();
				line2.add("Qualifications");
				line2.setAlignment(Element.ALIGN_CENTER);				
				document.add(line2);
				
				Paragraph Qualifications = new Paragraph();
				Qualifications.add("                                                           ");
				Qualifications.setAlignment(Element.ALIGN_CENTER);
				document.add(Qualifications);
				
				PdfPTable qualTable = new PdfPTable(7);
				PdfPCell qualType = new PdfPCell(new Phrase("Qual Type"));
				qualType.setHorizontalAlignment(Element.ALIGN_CENTER);
				qualTable.addCell(qualType);

				PdfPCell schoolName = new PdfPCell(new Phrase("School Name"));
				schoolName.setHorizontalAlignment(Element.ALIGN_CENTER);
				qualTable.addCell(schoolName);

				PdfPCell degree = new PdfPCell(new Phrase("Degree"));
				degree.setHorizontalAlignment(Element.ALIGN_CENTER);
				qualTable.addCell(degree);

				PdfPCell field = new PdfPCell(new Phrase("Field Of Study"));
				field.setHorizontalAlignment(Element.ALIGN_CENTER);
				qualTable.addCell(degree);

				PdfPCell activity = new PdfPCell(
						new Phrase("Field Of Activity"));
				activity.setHorizontalAlignment(Element.ALIGN_CENTER);
				qualTable.addCell(activity);

				PdfPCell fromDate = new PdfPCell(new Phrase("Start Date"));
				fromDate.setHorizontalAlignment(Element.ALIGN_CENTER);
				qualTable.addCell(fromDate);

				PdfPCell thruDate = new PdfPCell(new Phrase("End Date"));
				thruDate.setHorizontalAlignment(Element.ALIGN_CENTER);
				qualTable.addCell(thruDate);
				qualTable.setHeaderRows(1);
				for (EmployeeQual qual : qualList) {
					if (!qual.getId().getQualType().getDescription().equals("")) {
						qualTable.addCell(qual.getId().getQualType()
								.getDescription());
					} else {
						qualTable.addCell("-");
					}
					if (!qual.getSchoolName().equals("")) {
						qualTable.addCell(qual.getSchoolName());
					} else {
						qualTable.addCell("-");
					}
					if (!qual.getDegree().equals("")) {
						qualTable.addCell(qual.getDegree());
					} else {
						qualTable.addCell("-");
					}
					if (!qual.getFieldOfStudy().equals("")) {
						qualTable.addCell(qual.getFieldOfStudy());
					} else {
						qualTable.addCell("-");
					}
					if (!qual.getFieldOfActivity().equals("")) {
						qualTable.addCell(qual.getFieldOfActivity());
					} else {
						qualTable.addCell("-");
					}
					if (qual.getFromDate() != null) {
						Date qualFromDate = qual.getFromDate();
						java.sql.Date qual_from_date = new java.sql.Date(
								qualFromDate.getTime());
						qualTable.addCell(myformat.format(qual_from_date));
					} else {
						qualTable.addCell("-");
					}
					if (qual.getThruDate() != null) {
						Date qualThruDate = qual.getThruDate();
						java.sql.Date qual_thru_date = new java.sql.Date(
								qualThruDate.getTime());
						qualTable.addCell(myformat.format(qual_thru_date));
					} else {
						qualTable.addCell("-");
					}
				}
				document.add(qualTable);
			}
			// ------------------------------Setting Employee
			// Experiences-------------------------------
			if (experienceList != null) {
				Paragraph space1 = new Paragraph();
				space1.add("                                                           ");
				space1.setAlignment(Element.ALIGN_CENTER);
				document.add(space1);
				
				Paragraph line3 = new Paragraph();
				line3.add("Experiences");
				line3.setAlignment(Element.ALIGN_CENTER);
				document.add(line3);
				
				Paragraph Experiences = new Paragraph();
				Experiences.add("                                                           ");
				Experiences.setAlignment(Element.ALIGN_CENTER);
				document.add(Experiences);
				
				PdfPTable expTable = new PdfPTable(6);
				PdfPCell position = new PdfPCell(new Phrase("Position Name"));
				position.setHorizontalAlignment(Element.ALIGN_CENTER);
				expTable.addCell(position);

				PdfPCell empType = new PdfPCell(new Phrase("Employment Type"));
				empType.setHorizontalAlignment(Element.ALIGN_CENTER);
				expTable.addCell(empType);

				PdfPCell location = new PdfPCell(new Phrase("Location"));
				location.setHorizontalAlignment(Element.ALIGN_CENTER);
				expTable.addCell(location);

				PdfPCell currentRole = new PdfPCell(new Phrase("Current Role?"));
				currentRole.setHorizontalAlignment(Element.ALIGN_CENTER);
				expTable.addCell(currentRole);

				PdfPCell startDate = new PdfPCell(new Phrase("Start Date"));
				startDate.setHorizontalAlignment(Element.ALIGN_CENTER);
				expTable.addCell(startDate);

				PdfPCell endDate = new PdfPCell(new Phrase("End Date"));
				endDate.setHorizontalAlignment(Element.ALIGN_CENTER);
				expTable.addCell(endDate);
				expTable.setHeaderRows(1);

				for (EmployeePositionFulfillment empPosition : experienceList) {
					if (!empPosition.getId().getPartyGroupPosition()
							.getPositionName().equals("")) {
						expTable.addCell(empPosition.getId()
								.getPartyGroupPosition().getPositionName());
					} else {
						expTable.addCell("-");
					}
					if (empPosition.getEmploymentType().equals("1")) {
						expTable.addCell("Full Time");
					} else if (empPosition.getEmploymentType().equals("2")) {
						expTable.addCell("Part Time");
					} else if (empPosition.getEmploymentType().equals("3")) {
						expTable.addCell("Intern Ship");
					} else {
						expTable.addCell("-");
					}
					if (!empPosition.getLocation().equals("")) {
						expTable.addCell(empPosition.getLocation());
					} else {
						expTable.addCell("-");
					}
					if (empPosition.getCurrentRole().equals("1")) {
						expTable.addCell("YES");
					} else if (empPosition.getCurrentRole().equals("2")) {
						expTable.addCell("NO");
					} else {
						expTable.addCell("-");
					}
					if (empPosition.getFromDate() != null) {
						Date positionFromDate = empPosition.getFromDate();
						java.sql.Date pos_from_date = new java.sql.Date(
								positionFromDate.getTime());
						expTable.addCell(myformat.format(pos_from_date));
					} else {
						expTable.addCell("-");
					}

					if (empPosition.getThruDate() != null) {
						Date posThruDate = empPosition.getThruDate();
						java.sql.Date pos_thru_date = new java.sql.Date(
								posThruDate.getTime());
						expTable.addCell(myformat.format(pos_thru_date));
					} else {
						expTable.addCell("-");
					}
				}
				document.add(expTable);
			}
			// close
			document.close();
			myForm.setSuccessMsg("Download Finished!!");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			myForm.setErrorMsg("File not found!!");
			e.printStackTrace();
		} catch (DocumentException e) {
			myForm.setErrorMsg("Document Exception!!");
			e.printStackTrace();
		} catch (MalformedURLException e) {
			myForm.setErrorMsg("Malformed URL Exception!!");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			myForm.setErrorMsg("IOException!!");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * public void getFirstLoadEmployeeList(EmployeeForm myForm, AdminForm
	 * loginForm) { List<Employee> empList = myEmployeeDao.getAllEmployeeList();
	 * myForm.setEmployeeList(empList); List<Status> status =
	 * myStatusDao.getLoadStatusList(); if (status != null) {
	 * myForm.setFrmStatusList(status); }
	 * 
	 * if (empList != null) { int totalEmp = empList.size();
	 * myForm.setFrmTotalEmployee(totalEmp); }
	 * 
	 * }
	 */
	public void getFirstLoadEmployeeList(EmployeeForm myForm,
			AdminForm loginForm) {
		List<Employee> empList = myEmployeeDao.getAllEmployeeList();
		List<EmpImageFile> imageFile=myEmpImageFileDao.getAllEmployeeImage();
		if(imageFile!=null){
			myForm.setFrmImageFileList(imageFile);
		}else{
			myForm.setFrmImageFileList(null);
		}
		if(empList!=null){
			myForm.setEmployeeList(empList);
		}else{
			myForm.setEmployeeList(null);
		}
		List<Status> status = myStatusDao.getLoadStatusList();
		if (status != null) {
			myForm.setFrmStatusList(status);
		}

		if (empList != null) {
			int totalEmp = empList.size();
			myForm.setFrmTotalEmployee(totalEmp);
		}
		
	}

	public void getLoadEmployeeListByStatus(EmployeeForm myForm,
			AdminForm loginForm) {
		List<Employee> empList = myEmployeeDao.getEmployeeListByStatus(Integer
				.parseInt(myForm.getFrmStatusName()));
		List<EmpImageFile> imageFile=myEmpImageFileDao.getAllEmployeeImage();
		if(imageFile!=null){
			myForm.setFrmImageFileList(imageFile);
		}else{
			myForm.setFrmImageFileList(null);
		}
		if (empList != null) {
			myForm.setEmployeeList(empList);
			int totalEmp = empList.size();
			myForm.setFrmTotalEmployee(totalEmp);
		}else{
			myForm.setEmployeeList(null);
		}
	}

	public void deActivateEmpAccount(EmployeeForm myForm, AdminForm loginForm) {
		Employee employee = myEmployeeDao.getEmployeeById(Integer
				.parseInt(myForm.getFrmEmployeeId()));
		Status status = myStatusDao.searchStatusByStatusName("INACTIVE");
		if (employee != null) {
			employee.setStatus(status);
			myEmployeeDao.saveEmployee(employee);
		}
	}

	public void activateEmpAccount(EmployeeForm myForm, AdminForm loginForm) {
		Employee employee = myEmployeeDao.getEmployeeById(Integer
				.parseInt(myForm.getFrmEmployeeId()));
		Status status = myStatusDao.searchStatusByStatusName("ACTIVE");
		if (employee != null) {
			employee.setStatus(status);
			myEmployeeDao.saveEmployee(employee);
		}
	}

	public void employeeCVDownloadWithoutImage(EmployeeViewProfileForm myForm,
			String fILE_NAME) {
		Employee employee = myEmployeeDao.getEmployeeById(myForm
				.getFrmEmployeeId());
		List<EmployeePositionFulfillment> experienceList = myEmployeeExpDao
				.getEmployeeExpListAll(employee);
		List<EmployeeQual> qualList = myEmployeeQualDao
				.getEmployeeQualListAll(employee);
		List<EmployeeSkill> skillList = myEmployeeSkillDao
				.getEmployeeSkillListAll(employee);
		EmployeePositionFulfillment currentPosition = myEmployeeExpDao
				.getCurrentPositionByLoginUser(employee);

		Document document = new Document();

		try {

			PdfWriter.getInstance(document, new FileOutputStream(fILE_NAME
					+ employee.getFirstName() + employee.getLastName() + "_"
					+ "CVForm" + ".pdf"));
			// open
			document.open();

			// ----------------------------------------Header-------------------------------------
			Font titleF = new Font();
			titleF.setSize(14);

			Paragraph title = new Paragraph("CURRICULUM VITAE", titleF);
			title.setAlignment(Element.ALIGN_CENTER);
			document.add(title);

			
			// ----------------------------------------Employee
			// Profile---------------------------
			Paragraph pName = new Paragraph();
			pName.add("Name					: ");
			pName.add(employee.getFirstName() + " " + employee.getLastName());
			pName.setAlignment(Element.ALIGN_MIDDLE);
			document.add(pName);
			if (currentPosition != null) {
				Paragraph pCurrentPosition = new Paragraph();
				pCurrentPosition.add("Current Position					: ");
				pCurrentPosition.add(currentPosition.getId()
						.getPartyGroupPosition().getPositionName());
				pCurrentPosition.setAlignment(Element.ALIGN_JUSTIFIED);
				document.add(pCurrentPosition);
			}
			Paragraph pFatherName = new Paragraph();
			pFatherName.add("Father Name	: ");
			pFatherName.add(employee.getFatherName());
			pFatherName.setAlignment(Element.ALIGN_JUSTIFIED);
			document.add(pFatherName);

			Paragraph pNrc = new Paragraph();
			pNrc.add("Nrc					: ");
			pNrc.add(employee.getNrc());
			pNrc.setAlignment(Element.ALIGN_JUSTIFIED);
			document.add(pNrc);

			SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = employee.getBirthDate();
			java.sql.Date birth_date = new java.sql.Date(date.getTime());

			Paragraph pBirth = new Paragraph();
			pBirth.add("Birth Date			: ");
			pBirth.add(myformat.format(birth_date));
			pBirth.setAlignment(Element.ALIGN_JUSTIFIED);
			document.add(pBirth);

			Paragraph pGender = new Paragraph();
			pGender.add("Gender			: ");
			pGender.add(employee.getGender());
			pGender.setAlignment(Element.ALIGN_JUSTIFIED);
			document.add(pGender);

			Paragraph pEmail = new Paragraph();
			pEmail.add("Email				: ");
			pEmail.add(employee.getEmail());
			pEmail.setAlignment(Element.ALIGN_JUSTIFIED);
			document.add(pEmail);

			Paragraph pPhone = new Paragraph();
			pPhone.add("Phone no			: ");
			pPhone.add(employee.getPhoneNo());
			pPhone.setAlignment(Element.ALIGN_JUSTIFIED);
			document.add(pPhone);

			Paragraph pAddress = new Paragraph();
			pAddress.add("Address			: ");
			pAddress.add(employee.getAddress());
			pAddress.setAlignment(Element.ALIGN_JUSTIFIED);
			document.add(pAddress);

			// -------------------------Setting Employee
			// Skill---------------------------
			if (skillList != null) {
				Paragraph line = new Paragraph();
				line.add("Skills");
				line.setAlignment(Element.ALIGN_CENTER);
				document.add(line);

				PdfPTable skilTable = new PdfPTable(2);
				PdfPCell c1 = new PdfPCell(new Phrase("Skill Name"));
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				skilTable.addCell(c1);

				PdfPCell c2 = new PdfPCell(new Phrase("SkillLevel"));
				c2.setHorizontalAlignment(Element.ALIGN_CENTER);
				skilTable.addCell(c2);
				skilTable.setHeaderRows(1);

				for (EmployeeSkill skill : skillList) {
					if (!skill.getId().getSkillType().getDescription()
							.equals("")) {
						skilTable.addCell(skill.getId().getSkillType()
								.getDescription());
					} else {
						skilTable.addCell("-");
					}
					if (!skill.getSkillLevel().equals("")) {
						skilTable.addCell(skill.getSkillLevel());
					} else {
						skilTable.addCell("-");
					}

				}
				document.add(skilTable);

			}
			// -------------------------Setting Employee
			// Qualification---------------------------
			if (qualList != null) {
				Paragraph line2 = new Paragraph();
				line2.add("Qualifications");
				line2.setAlignment(Element.ALIGN_CENTER);
				document.add(line2);

				PdfPTable qualTable = new PdfPTable(7);
				PdfPCell qualType = new PdfPCell(new Phrase("Qual Type"));
				qualType.setHorizontalAlignment(Element.ALIGN_CENTER);
				qualTable.addCell(qualType);

				PdfPCell schoolName = new PdfPCell(new Phrase("School Name"));
				schoolName.setHorizontalAlignment(Element.ALIGN_CENTER);
				qualTable.addCell(schoolName);

				PdfPCell degree = new PdfPCell(new Phrase("Degree"));
				degree.setHorizontalAlignment(Element.ALIGN_CENTER);
				qualTable.addCell(degree);

				PdfPCell field = new PdfPCell(new Phrase("Field Of Study"));
				field.setHorizontalAlignment(Element.ALIGN_CENTER);
				qualTable.addCell(degree);

				PdfPCell activity = new PdfPCell(
						new Phrase("Field Of Activity"));
				activity.setHorizontalAlignment(Element.ALIGN_CENTER);
				qualTable.addCell(activity);

				PdfPCell fromDate = new PdfPCell(new Phrase("Start Date"));
				fromDate.setHorizontalAlignment(Element.ALIGN_CENTER);
				qualTable.addCell(fromDate);

				PdfPCell thruDate = new PdfPCell(new Phrase("End Date"));
				thruDate.setHorizontalAlignment(Element.ALIGN_CENTER);
				qualTable.addCell(thruDate);
				qualTable.setHeaderRows(1);
				for (EmployeeQual qual : qualList) {
					if (!qual.getId().getQualType().getDescription().equals("")) {
						qualTable.addCell(qual.getId().getQualType()
								.getDescription());
					} else {
						qualTable.addCell("-");
					}
					if (!qual.getSchoolName().equals("")) {
						qualTable.addCell(qual.getSchoolName());
					} else {
						qualTable.addCell("-");
					}
					if (!qual.getDegree().equals("")) {
						qualTable.addCell(qual.getDegree());
					} else {
						qualTable.addCell("-");
					}
					if (!qual.getFieldOfStudy().equals("")) {
						qualTable.addCell(qual.getFieldOfStudy());
					} else {
						qualTable.addCell("-");
					}
					if (!qual.getFieldOfActivity().equals("")) {
						qualTable.addCell(qual.getFieldOfActivity());
					} else {
						qualTable.addCell("-");
					}
					if (qual.getFromDate() != null) {
						Date qualFromDate = qual.getFromDate();
						java.sql.Date qual_from_date = new java.sql.Date(
								qualFromDate.getTime());
						qualTable.addCell(myformat.format(qual_from_date));
					} else {
						qualTable.addCell("-");
					}
					if (qual.getThruDate() != null) {
						Date qualThruDate = qual.getThruDate();
						java.sql.Date qual_thru_date = new java.sql.Date(
								qualThruDate.getTime());
						qualTable.addCell(myformat.format(qual_thru_date));
					} else {
						qualTable.addCell("-");
					}
				}
				document.add(qualTable);
			}
			// ------------------------------Setting Employee
			// Experiences-------------------------------
			if (experienceList != null) {
				Paragraph line3 = new Paragraph();
				line3.add("Experiences");
				line3.setAlignment(Element.ALIGN_CENTER);
				document.add(line3);

				PdfPTable expTable = new PdfPTable(6);
				PdfPCell position = new PdfPCell(new Phrase("Position Name"));
				position.setHorizontalAlignment(Element.ALIGN_CENTER);
				expTable.addCell(position);

				PdfPCell empType = new PdfPCell(new Phrase("Employment Type"));
				empType.setHorizontalAlignment(Element.ALIGN_CENTER);
				expTable.addCell(empType);

				PdfPCell location = new PdfPCell(new Phrase("Location"));
				location.setHorizontalAlignment(Element.ALIGN_CENTER);
				expTable.addCell(location);

				PdfPCell currentRole = new PdfPCell(new Phrase("Current Role?"));
				currentRole.setHorizontalAlignment(Element.ALIGN_CENTER);
				expTable.addCell(currentRole);

				PdfPCell startDate = new PdfPCell(new Phrase("Start Date"));
				startDate.setHorizontalAlignment(Element.ALIGN_CENTER);
				expTable.addCell(startDate);

				PdfPCell endDate = new PdfPCell(new Phrase("End Date"));
				endDate.setHorizontalAlignment(Element.ALIGN_CENTER);
				expTable.addCell(endDate);
				expTable.setHeaderRows(1);

				for (EmployeePositionFulfillment empPosition : experienceList) {
					if (!empPosition.getId().getPartyGroupPosition()
							.getPositionName().equals("")) {
						expTable.addCell(empPosition.getId()
								.getPartyGroupPosition().getPositionName());
					} else {
						expTable.addCell("-");
					}
					if (empPosition.getEmploymentType().equals("1")) {
						expTable.addCell("Full Time");
					} else if (empPosition.getEmploymentType().equals("2")) {
						expTable.addCell("Part Time");
					} else if (empPosition.getEmploymentType().equals("3")) {
						expTable.addCell("Intern Ship");
					} else {
						expTable.addCell("-");
					}
					if (!empPosition.getLocation().equals("")) {
						expTable.addCell(empPosition.getLocation());
					} else {
						expTable.addCell("-");
					}
					if (empPosition.getCurrentRole().equals("1")) {
						expTable.addCell("YES");
					} else if (empPosition.getCurrentRole().equals("2")) {
						expTable.addCell("NO");
					} else {
						expTable.addCell("-");
					}
					if (empPosition.getFromDate() != null) {
						Date positionFromDate = empPosition.getFromDate();
						java.sql.Date pos_from_date = new java.sql.Date(
								positionFromDate.getTime());
						expTable.addCell(myformat.format(pos_from_date));
					} else {
						expTable.addCell("-");
					}

					if (empPosition.getThruDate() != null) {
						Date posThruDate = empPosition.getThruDate();
						java.sql.Date pos_thru_date = new java.sql.Date(
								posThruDate.getTime());
						expTable.addCell(myformat.format(pos_thru_date));
					} else {
						expTable.addCell("-");
					}
				}
				document.add(expTable);
			}
			// close
			document.close();
			myForm.setSuccessMsg("Download Finished!!");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			myForm.setErrorMsg("File not found!!");
			e.printStackTrace();
		} catch (DocumentException e) {
			myForm.setErrorMsg("Document Exception!!");
			e.printStackTrace();
		
		}
	}

}
