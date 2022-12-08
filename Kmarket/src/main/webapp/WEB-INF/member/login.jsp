<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="./_header.jsp"/>
        <main id="member">
            <div class="login">
                <nav>
                    <h1>ë¡ê·¸ì¸</h1>
                    <p>
                        HOME > <strong>ë¡ê·¸ì¸</strong>
                    </p>
                </nav>

                <form action="#">
                    
                    <table border="0">
                        <tr>
                            <td>ìì´ë</td>
                            <td><input type="text" name="uid" placeholder="ìì´ë ìë ¥"></td>
                        </tr>
                        <tr>
                            <td>ë¹ë°ë²í¸</td>
                            <td><input type="password" name="pass" placeholder="ë¹ë°ë²í¸ ìë ¥"></td>
                        </tr>
                    </table>
                    <input type="submit" value="ë¡ê·¸ì¸"/>
                    <span>
                        <label><input type="checkbox" name="auto"/>ìë ë¡ê·¸ì¸</label>
                        <a href="#">ìì´ëì°¾ê¸°</a>
                        <a href="#">ë¹ë°ë²í¸ì°¾ê¸°</a>
                        <a href="#">íìê°ì</a>
                    </span>
                    <a href="#" class="banner"><img src="./img/member_login_banner.jpg" alt="1ë§ì í ì¸ ì¿ í° ë°ê¸°"></a>
                </form>
                <img src="./img/member_certifi_logo.gif" alt="banner">
            </div>
        </main>
<jsp:include page="./_footer.jsp"/>   