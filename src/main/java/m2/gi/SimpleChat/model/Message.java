package m2.gi.SimpleChat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Message {
	@Id
	@SequenceGenerator(	name="message_id_message_seq",
	sequenceName="message_id_message_seq",
	allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="message_id_message_seq")
	@Column(name="id_message")
	private Long id;
	
	@Column
	private String content;

	public Message() {
		super();
	}

	public Message(Long id, String content) {
		super();
		this.id = id;
		this.content = content;
	}
	
	public Message(String content)
	{
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", content=" + content + "]";
	}
		
}
