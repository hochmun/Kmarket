<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ì¼ì´ë§ì¼ ê³ ê°ì¼í°</title>
    <link rel="shortcut icon" type="image/x-icon" href="../../img/favicon.ico">
    <link rel="stylesheet" href="../css/cs.css">
</head>
<body>
    <div id="wrapper">
        <header>
            <div class="top">
                <div>
                    <p>
                        <a href="../../member/login.html">ë¡ê·¸ì¸</a>
                        <a href="#">íìê°ì</a>
                        <a href="#">ë§ì´íì´ì§</a>
                        <a href="#"><i class="fa fa-shopping-cart" aria-hidden="true"></i
                        >&nbsp;ì¥ë°êµ¬ë</a>
                    </p>
                </div>
            </div>
            <div class="logo">
                <div>
                    <a href="#"><img src="../img/logo.png" alt="ë¡ê³ ">ê³ ê°ì¼í°</a>
                </div>
            </div>
        </header>

        <section id="cs">
            <div class="qna">
                <nav>
                    <div>
                        <p>í<span>></span>ë¬¸ìíê¸°</p>
                    </div>
                </nav>
                <section class="write">
                    <aside>
                        <h2>ë¬¸ìíê¸°</h2>
                        <ul>
                            <li class="on"><a href="#">íì</a></li>
                            <li><a href="#">ì¿ í°/ì´ë²¤í¸</a></li>
                            <li><a href="#">ì£¼ë¬¸/ê²°ì </a></li>
                            <li><a href="#">ë°°ì¡</a></li>
                            <li><a href="#">ì·¨ì/ë°í/êµí</a></li>
                            <li><a href="#">ì¬í/ìë°/í­ê³µ</a></li>
                            <li><a href="#">ìì ê±°ë</a></li>
                        </ul>
                    </aside>
                    <article>
                        <form action="#">
                            <table>
                                <tr>
                                    <td>ë¬¸ìì í</td>
                                    <td>
                                        <select name="type">
                                            <option value="0">ì í</option>
                                            <option value="">ê°ì</option>
                                            <option value="">íí´</option>
                                            <option value="">íìì ë³´</option>
                                            <option value="">ë¡ê·¸ì¸</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>ë¬¸ìì ëª©</td>
                                    <td>
                                        <input type="text" name="title" placeholder="ì ëª©ì ìë ¥íì¸ì.">
                                    </td>
                                </tr>
                                <tr>
                                    <td>ë¬¸ìë´ì©</td>
                                    <td>
                                        <textarea name="content" placeholder="ë´ì©ì ìë ¥íì¸ì."></textarea>
                                    </td>
                                </tr>
                            </table>
                            <div>
                                <a href="./list.html" class="btnList">ì·¨ìíê¸°</a>
                                <input type="submit" class="btnSubmit" value="ë±ë¡íê¸°">
                            </div>
                        </form>
                    </article>
                </section>
            </div>
        </section>

        <footer>
            <ul>
                <li><a href="#">íì¬ìê°</a></li>
                <li><a href="#">ìë¹ì¤ì´ì©ì½ê´</a></li>
                <li><a href="#">ê°ì¸ì ë³´ì²ë¦¬ë°©ì¹¨</a></li>
                <li><a href="#">ì ìê¸ìµê±°ëì½ê´</a></li>
            </ul>
            <div>
                <p><img src="../../img/footer_logo.png" alt="ë¡ê³ "></p>
                <p>
                    <strong>(ì£¼)KMARKET</strong><br/>
                    ë¶ì°ì ê°ë¨êµ¬ íí¤ëë¡ 152 (ì­ì¼ë ê°ë¨íì´ë¸ì¤ì¼í°)<br/>
                    ëíì´ì¬ : íê¸¸ë<br/>
                    ì¬ììë±ë¡ë²í¸ : 220-81-83676 ì¬ììì ë³´íì¸<br/>
                    íµì íë§¤ìì ê³  : ê°ë¨ 10630í¸ Fax : 02-589-8842
                </p>
                <p>
                    <strong>ê³ ê°ì¼í°</strong><br/>
                    Tel : 1234-5678 (íì¼ 09:00 ~ 18:00)<br/>
                    ì¤ë§ì¼í´ë½/SVIP ì ì© : 1522-5700 (365ì¼ 09:00 ~ 18:00)<br/>
                    ê²½ê¸°ë ë¶ì²ì ìë¯¸êµ¬ ë¶ì¼ë¡ 223(ìë) í¬ëë¹ë© 6ì¸µ<br/>
                    Fax : 051-123-4567 | Mail : kmarket@kmarket.co.kr<br/>
                </p>
            </div>
        </footer>
    </div>
</body>
</html>