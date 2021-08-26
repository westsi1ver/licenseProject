package model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
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
@Table(name = "TEST_USER")
@SequenceGenerator(name = "TestUser_seq", sequenceName = "TestUser_no_seq", initialValue = 1, allocationSize = 1)
@NamedQuery(query = "select t from TestUser t where t.userId=:userId", name = "TestUser.findbyuserId")

public class TestUser {

	@Id
	@Column(name = "user_number")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TestUser_seq")
	private int userNumber;

	@Column(name = "user_id")
	private String userId;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "user_phone")
	private String userPhone;

	@Column(name = "user_hopeloc")
	private String userHopeloc;

	@Column(name = "test_result")
	private String testResult;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "test_number")
	private TestT testNumber;

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" [접수자 고유 번호] : ");
		builder.append(userNumber);
		builder.append(" [접수자 ID] : ");
		builder.append(userId);
		builder.append(" [접수자 이름] : ");
		builder.append(userName);
		builder.append(" [접수자 연락처] : ");
		builder.append(userPhone);
		builder.append(" [시험장 희망지역] : ");
		builder.append(userHopeloc);
		builder.append(" [접수한 시험고유 번호] : ");
		builder.append(testNumber);
		builder.append(" [시험결과]: ");
		builder.append(testResult);

		return builder.toString();
	}

}
