package model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="TEST_ORG")
@SequenceGenerator(name="testOrg_seq", sequenceName="testOrg_no_seq", initialValue=1, allocationSize=1)

public class TestOrg {
	
	@Id
	@Column(name="org_number")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "testOrg_seq")
	private int orgNumber;
	
	@Column(name="org_name")
	private String orgName;
	
	@Column(name="org_phone")
	private String orgPhone;
	
	@Column(name="org_url")
	private String orgUrl;
	
	
	@OneToMany(mappedBy="orgNumber")
	List<TestT> TestList = new ArrayList<>();
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[1. 기관번호] : ");
		builder.append(orgNumber);
		builder.append("[2. 기관이름]: ");
		builder.append(orgName);
		builder.append("[3. 기관번호] : ");
		builder.append(orgPhone);
		builder.append("[4.기관 홈페이지] : ");
		builder.append(orgUrl);
			
		return builder.toString();
	}
}
