package user.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "id")
@Entity
@Table(name="address")
public class Address {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "user_id")
	private long userId;
	
	@Column(nullable=false, length=75)
	private String street;
	
	@Column()
	private int number;
	
	@Column()
	private int pc;
	
	public Address(long userId, String street, Integer number, Integer pc) {
		this(null, userId, street, number, pc);
	}
}
