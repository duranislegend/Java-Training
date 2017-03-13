package lcy.ccdn.note;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

class Member{
	private int id;
	private String name;
	private String score;
	Member(int id, String name,String score){
		this.id = id;
		this.name = name;
		this.score = score;
	}
	public void save() throws IOException{
		try {
			
			/*FileOutputStream out = new FileOutputStream(new File(Integer.toString(id)));
			out.write(id);
			byte[] b = name.getBytes();
			int bl = b.length;
			out.write(b,4,bl);
			byte[] s = score.getBytes();
			int sl = s.length;
			out.write(s,4+bl,sl);*/
			DataOutputStream out = new DataOutputStream(new FileOutputStream(Integer.toString(id)));
			out.writeInt(id);
			out.writeUTF(name);
			out.writeUTF(score);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Member get(int number) throws FileNotFoundException{
		/*FileInputStream in = new FileInputStream(new File(Integer.toString(number)));
		byte[] data = new byte[1024];
		int length = in.read(data);
		for(byte b :data){
			b
		}
		return Member;*/
		DataInputStream in;
		in = new DataInputStream(new FileInputStream(Integer.toString(number)));
		Member member = null;
		try {
			member = new Member(in.readInt(),in.readUTF(),in.readUTF());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return member;
		
	}
	@Override
	public String toString(){
		return String.format("(%d,%s,%s)",id,name,score);
	}
}
public class DataInputOutputStreamDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Member mem1 = new Member(1,"xx","96");
		mem1.save();
		Member mem = mem1.get(1);
		System.out.println(mem);
		

	}

}
