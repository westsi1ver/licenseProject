package model.entity;

import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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

@SequenceGenerator(name="testT_seq", sequenceName="testT_no_seq", initialValue=10, allocationSize=1)
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
	
	@Temporal(TemporalType.DATE)
	@Column(name="test_enddate")
	private Date testEndDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="test_day")
	private Date testDay;
	
	
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
		builder.append("[시험 고유번호] : ");
		builder.append(testNumber);
		builder.append(" [시험명] : ");
		builder.append(testName);
		builder.append(" [시험 응시료] : ");
		builder.append(testFee);
		builder.append("원");
		builder.append(" [접수 마감일] : ");
		builder.append(testEndDate);
		builder.append(" [시험 날짜] : ");
		builder.append(testDay);
//		builder.append("[기관 번호] : ");
//		builder.append(orgNumber);
		return builder.toString();
	}
	
}
