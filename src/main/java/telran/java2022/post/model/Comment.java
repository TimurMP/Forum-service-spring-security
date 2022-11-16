package telran.java2022.post.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@EqualsAndHashCode(of = { "user", "dateCreated" })
public class Comment {
	@Setter
	String user;
	@Setter
	String message;
	LocalDateTime dateCreated;
	int likes;

	public Comment() {
		dateCreated = LocalDateTime.now();
	}

	public Comment(String user, String message) {
		this();
		this.user = user;
		this.message = message;
	}

	public void addLike() {
		likes++;
	}
}
