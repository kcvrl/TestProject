/*
 * Created on Aug 17, 2007
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
import java.util.ArrayList;
import java.util.Vector;

import com.ibm.mm.sdk.common.DKNotExistException;
import com.ibm.mm.sdk.common.DKUserDefICM;
import com.ibm.mm.sdk.common.DKUserMgmtICM;
import com.ibm.mm.sdk.common.dkCollection;
import com.ibm.mm.sdk.common.dkIterator;
import com.ibm.mm.sdk.server.DKDatastoreICM;
 
//import javax.servlet.http.HttpSession;

  
public class AddUser { 
	public static void main(String[] args){  
		try{   
			AddUser adduser=new AddUser();
		DKDatastoreICM datastore = new DKDatastoreICM();
        datastore.connect("CMLSDEV", "64470004", "BTIIQCN0", "CMLSDEV");       
        DKUserMgmtICM userMgnt = new DKUserMgmtICM( datastore );     
       System.out.println("Is Connected ::\t"+userMgnt.getDatastore().isConnected()); 
                  
       
       //Name, password, privilege code, resource manager, collection and item access
      String USERID="i362023";
      String USERNAME="kasi";
      String DEPRT="Q0111983"; 
      String USERTYPE="Employee";
      Vector grpToAdd=new Vector();
      grpToAdd.add("GRP_DN_CLAIM_EXAMSUP");
      DKUserDefICM newCMuser = ( DKUserDefICM )userMgnt.createUserDef(); 
       newCMuser.setName(USERID.toUpperCase().trim());    
       newCMuser.setDescription(USERNAME.toUpperCase().trim());  
       newCMuser.setUserDN("Test:Test");
       newCMuser.setUserPWD(USERID); //pwd
       newCMuser.setPwdExpire(0); //pwd expiore
       newCMuser.setPrivSetName("UPDATE_WFL"); //Privs set
       newCMuser.setGrantPrivSetName("UPDATE_WFL");   //Priv set                  
       newCMuser.setCollName("ECMD.CZD011D");    //Coll 
       newCMuser.setDflItemACLName("CLMATTACH_ACL");   //Item Access   
       newCMuser.setObjServerName( "DT01RM2" ); //RM
       newCMuser.setPrivSetCode(1003);  
	newCMuser.setGroups(grpToAdd);
       userMgnt.add(newCMuser); 
       
       datastore.disconnect();
      	datastore.destroy(); 
       
      
		}catch(Exception e){
			System.out.println(e);
		}
	} 


}

