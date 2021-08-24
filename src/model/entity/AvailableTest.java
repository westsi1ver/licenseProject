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
@Table(name="AVAILABLE_TEST")
@SequenceGenerator(name = "avaTest_seq", sequenceName = "avaTest_no_seq", initialValue = 1, allocationSize = 1)
public class AvailableTest {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "avaTest_seq")
	@Column(name = "ava_id")
	private int avaId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "loc_number")
	private TestLoc locNumber;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "test_number")
	private TestT testNumber;

	@Column(name = "available_test")
	private String availableTest;

	@OneToMany(mappedBy = "testNumber")
	List<TestUser> TestUserList = new ArrayList<>();

	public int getPlayerCount() {
		return TestUserList.size();
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[1. 좌석번호] : ");
		builder.append(avaId);
		builder.append("[2. 시험장소 번호] : ");
		builder.append(locNumber);
		builder.append("[3. 수험번호] : ");
		builder.append(testNumber);
		builder.append("[4. 잔여좌석] ");
		builder.append(availableTest);

		return builder.toString();
	}

}
