package jdbcİntro;

public class Actor {
	private String actor_id;
	private String first_name;
	private String last_name;
	private String last_update;
	
	public Actor(String actor_id,String first_name,String last_name,String last_update) {
		this.actor_id = actor_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.last_update = last_update;
	}
}
