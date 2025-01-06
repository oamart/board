package frontController;

import java.util.HashMap;
import java.util.Map;

import controller.board.AddReply;
import controller.board.BbsController;
import controller.board.Delete;
import controller.board.List;
import controller.board.ReplyView;
import controller.board.Update;
import controller.board.View;
import controller.board.Write;
import controller.member.MemberDelete;
import controller.member.MemberInsert;
import controller.member.MemberList;
import controller.member.MemberUpdate;
import controller.member.UserInfo;

public class ActionMapping {
	private Map<String, BbsController> actionMap = new HashMap<String, BbsController>();
	
	public ActionMapping() {
		actionMap.put("write.do", new Write());
    	actionMap.put("list.do", new List());
    	actionMap.put("view.do", new View());
    	actionMap.put("del.do", new Delete());
    	actionMap.put("update.do", new Update());
    	actionMap.put("replyView.do", new ReplyView());
    	actionMap.put("addReply.do", new AddReply());
    	
    	actionMap.put("memberList.do", new MemberList());
    	actionMap.put("memberDelete.do", new MemberDelete());
    	actionMap.put("memberUpdate.do", new MemberUpdate());
    	actionMap.put("memberInsert.do", new MemberInsert());
    	actionMap.put("userInfo.do", new UserInfo());
	}
	
	public BbsController get(String key) {
		return actionMap.get(key);
	}

	
}
