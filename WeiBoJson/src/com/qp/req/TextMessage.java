package com.qp.req;

public class TextMessage {
		//私信内容
		private String text;
		private String receiver_id;
		private String sender_id;
		private String type;
		private String created_at;
		//private String event;
		//private String data;
		/**
		 * @return the text
		 */
		public String getText() {
			return text;
		}
		
		/**
		 * @param text the text to set
		 */
		public void setText(String text) {
			this.text = text;
		}
		/**
		 * @return the receiver_id
		 */
		public String getReceiver_id() {
			return receiver_id;
		}
		/**
		 * @param receiver_id the receiver_id to set
		 */
		public void setReceiver_id(String receiver_id) {
			this.receiver_id = receiver_id;
		}
		/**
		 * @return the sender_id
		 */
		public String getSender_id() {
			return sender_id;
		}
		/**
		 * @param sender_id the sender_id to set
		 */
		public void setSender_id(String sender_id) {
			this.sender_id = sender_id;
		}
		/**
		 * @return the type
		 */
		public String getType() {
			return type;
		}
		/**
		 * @param type the type to set
		 */
		public void setType(String type) {
			this.type = type;
		}
		/**
		 * @return the created_at
		 */
		public String getCreated_at() {
			return created_at;
		}
		/**
		 * @param created_at the created_at to set
		 */
		public void setCreated_at(String created_at) {
			this.created_at = created_at;
		}
		
		public String toString() {
			
			return  "text: "+text+" receiver_id: "+receiver_id+" sender_id:  "+sender_id+" type: "+type+" created_at: "+created_at;
			
		}
		

}
