package Bean;

public class Beanid {
		private String id;
		private String password;
		private String jiese;


		public String getJiese() {
			return jiese;
		}
		public void setJiese(String jiese) {
			this.jiese = jiese;
		}
		public String getId() {
		    return id;
		}
		public void setId(String id) {
		    this.id = id;
		}
		public String getPassword() {
		    return password;
		}
		public void setPassword(String password) {
		    this.password = password;
		}

		public Beanid(){}
		public Beanid(String password) {
		    
		    this.password = password;
		};
		public Beanid(String jiese,String id, String password) {
		    this.jiese = jiese;
		    this.id = id;
		    this.password = password;
		    
		}
}
