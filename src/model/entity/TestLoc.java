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
@Table(name="TEST_LOC")
@SequenceGenerator(name = "testLoc_seq", sequenceName = "testLoc_no_seq", initialValue = 1, allocationSize = 1)
public class TestLoc {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "testLoc_seq")
	@Column(name = "loc_number")
	private int locNumber;

	@Column(name = "test_loc")
	private String testLoc;

	@Column(name = "loc_name")
	private String locName;
	
	@OneToMany(mappedBy="locNumber")
	List<AvailableTest> avaTest = new ArrayList<>(); 
	


//	@OneToMany(mappedBy="dteamNo")
//	List<TestOrg> dList = new ArrayList<>();

	public int getPlayerCount() {
		return avaTest.size();
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[1. 장소번호] : ");
		builder.append(locNumber);
		builder.append("[2. 지역] : ");
		builder.append(testLoc);
		builder.append("[3. 시험장소] : ");
		builder.append(locName);

		return builder.toString();
	}

}
