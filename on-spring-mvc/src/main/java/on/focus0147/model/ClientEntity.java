package on.focus0147.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "CLIENTS")
public class ClientEntity implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID")
	protected Long id;

	@NotEmpty
	@Size(min = 2, max = 30)
	@Column(name = "FIRST_NAME")
	private String firstName;

	@NotEmpty
	@Size(min = 2, max = 30)
	@Column(name = "LAST_NAME")
	private String lastName;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "BIRTH_DATE")
	private LocalDate birthDate;

	@Basic(fetch= FetchType.LAZY)
	@Lob
	@Column(name = "PHOTO")
	private byte[] photo;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ClientEntity clientEntity = (ClientEntity) o;
		if(this.id != null) {
			return this.id.equals(((ClientEntity) o).id);
		}
		return firstName.equals(clientEntity.firstName) && lastName.equals(clientEntity.lastName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName);
	}

	public String toString() {
		return "Client - Id: " + id + ", First name: " + firstName
				+ ", Last name: " + lastName + ", Birthday: " + birthDate;
	}
}
