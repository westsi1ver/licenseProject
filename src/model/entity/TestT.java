package model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="TEST_T")
@SequenceGenerator(name="testT_seq", sequenceName="testT_no_seq", initialValue=1, allocationSize=1)
@NamedQuery(query = "select t from TestT t where t.testName=:testName", name = "TestT.findbyTestName")
@NamedQuery(query = "select t from TestT t where t.testFee<=:testFee", name = "TestT.findbyTestFee")

public class TestT {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="testT_seq")
	@Column(name="test_number")
	private int testNumber;
	
	@Column(name="test_name")
	private String testName;

	@Column(name="test_fee")
	private int testFee;
	
	@Column(name="test_enddate")
	private String testEndDate;
	
	@Column(name="test_day")
	private String testDay;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="org_number")
	private TestOrg orgNumber;
	
	
	@OneToMany(mappedBy="testNumber")
	List<TestUser> TestUserList = new ArrayList<>();
	
//	@OneToMany(mappedBy="dteamNo")
//	List<TestOrg> dList = new ArrayList<>();
	
	public int getPlayerCount() {
		return TestUserList.size();
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[1. 수험번호] : ");
		builder.append(testNumber);
		builder.append("[2. 시험명] : ");
		builder.append(testName);
		builder.append("[3. 시험응시료] : ");
		builder.append(testFee);
		builder.append("[4. 접수마감일] ");
		builder.append(testEndDate);
		builder.append("[5. 시험날짜] : ");
		builder.append(testDay);
		builder.append("[6. 기관번호] : ");
		builder.append(orgNumber);
		return builder.toString();
	}
	
}
