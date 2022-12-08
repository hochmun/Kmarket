<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ì¼ì´ë§ì¼::ê´ë¦¬ì</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    <script src="https://kit.fontawesome.com/20962f3e4b.js" crossorigin="anonymous"></script>    
    <script src="../js/gnb.js"></script>
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="../css/admin.css">
</head>
<body>
    <div id="admin-wrapper">
        <header>
            <div>
                <a href="../index.html" class="logo">
                    <img src="../img/admin_logo.png" alt="admin_logo">
                </a>
                <p>
                    <span>íê¸¸ëë ë°ê°ìµëë¤.</span>
                    <a href="#">HOME |</a>
                    <a href="#">ë¡ê·¸ìì |</a>
                    <a href="#">ê³ ê°ì¼í°</a>
                </p>
            </div>
        </header>
        <main>
            <aside>
                <!-- Global Navigation Bar -->
                <ul id="gnb">
                    <li>
                        <a href="#"><i class="fa fa-cogs" aria-hidden="true"></i>íê²½ì¤ì </a>
                        <ol>
                            <li><a href="#">ê¸°ë³¸íê²½ì¤ì </a></li>
                            <li><a href="#">ë°°ëê´ë¦¬</a></li>
                        </ol>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-store" aria-hidden="true"></i>ìì ê´ë¦¬</a>
                        <ol>
                            <li><a href="#">íë§¤ìíí©</a></li>
                            <li><a href="#">ì¬ê³ ê´ë¦¬</a></li>
                        </ol>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-users" aria-hidden="true"></i>íìê´ë¦¬</a>
                        <ol>
                            <li><a href="#">íìíí©</a></li>
                            <li><a href="#">í¬ì¸í¸ê´ë¦¬</a></li>
                            <li><a href="#">ë¹íìê´ë¦¬</a></li>
                            <li><a href="#">ì ììì§ê³</a></li>
                        </ol>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-box-open" aria-hidden="true"></i>ìíê´ë¦¬</a>
                        <ol>
                            <li><a href="#">ìííí©</a></li>
                            <li><a href="#">ìíë±ë¡</a></li>
                            <li><a href="#">ì¬ê³ ê´ë¦¬</a></li>
                        </ol>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-credit-card" aria-hidden="true"></i>ì£¼ë¬¸ê´ë¦¬</a>
                        <ol>
                            <li><a href="#">ì£¼ë¬¸íí©</a></li>
                            <li><a href="#">ë§¤ì¶íí©</a></li>
                            <li><a href="#">ê²°ì ê´ë¦¬</a></li>
                            <li><a href="#">ë°°ì¡ê´ë¦¬</a></li>
                        </ol>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-pencil-square-o" aria-hidden="true"></i>ê²ìíê´ë¦¬</a>
                        <ol>
                            <li><a href="#">ê²ìííí©</a></li>
                            <li><a href="#">ê³ ê°ë¬¸ì</a></li>
                        </ol>
                    </li>
                </ul>
            </aside>
            <section id="admin-product-list">
                <nav>
                    <h3>ìíëª©ë¡</h3>
                    <p>
                        HOME > ìíê´ë¦¬ > <strong>ìíëª©ë¡</strong>
                    </p>
                </nav>
                <!-- ìíëª©ë¡ ì»¨íì¸  ìì -->
                <section>
                    <div>
                        <select name="search">
                            <option value="search1">ìíëª</option>
                            <option value="search2">ìíì½ë</option>
                            <option value="search3">ì ì¡°ì¬</option>
                            <option value="search4">íë§¤ì</option>
                        </select>
                        <input type="text" name="search">
                    </div>
                    <table>
                        <tr>
                            <th><input type="checkbox" name="all"></th>
                            <th>ì´ë¯¸ì§</th>
                            <th>ìíì½ë</th>
                            <th>ìíëª</th>
                            <th>íë§¤ê°ê²©</th>
                            <th>í ì¸ì¨</th>
                            <th>í¬ì¸í¸</th>
                            <th>ì¬ê³ </th>
                            <th>íë§¤ì</th>
                            <th>ì¡°í</th>
                            <th>ê´ë¦¬</th>
                        </tr>

                        <tr>
                            <td><input type="checkbox" name="ìíì½ë"></td>
                            <td><img src="../img/sample_thumb.jpg" class="thumb"></td>
                            <td>201603292</td>
                            <td>FreeMovement BLUEFORCE</td>
                            <td>36,000</td>
                            <td>10</td>
                            <td>360</td>
                            <td>400</td>
                            <td>íê¸¸ë</td>
                            <td>126</td>
                            <td>
                                <a href="#">[ì­ì ]</a>
                                <a href="#">[ìì ]</a>
                            </td>
                        </tr>
                        <tr>
                            <td><input type="checkbox" name="ìíì½ë"></td>
                            <td><img src="../img/sample_thumb.jpg" class="thumb"></td>
                            <td>201603292</td>
                            <td>FreeMovement BLUEFORCE</td>
                            <td>36,000</td>
                            <td>10</td>
                            <td>360</td>
                            <td>400</td>
                            <td>íê¸¸ë</td>
                            <td>126</td>
                            <td>
                                <a href="#">[ì­ì ]</a>
                                <a href="#">[ìì ]</a>
                            </td>
                        </tr>
                        <tr>
                            <td><input type="checkbox" name="ìíì½ë"></td>
                            <td><img src="../img/sample_thumb.jpg" class="thumb"></td>
                            <td>201603292</td>
                            <td>FreeMovement BLUEFORCE</td>
                            <td>36,000</td>
                            <td>10</td>
                            <td>360</td>
                            <td>400</td>
                            <td>íê¸¸ë</td>
                            <td>126</td>
                            <td>
                                <a href="#">[ì­ì ]</a>
                                <a href="#">[ìì ]</a>
                            </td>
                        </tr>

                    </table>

                    <input type="button" value="ì íì­ì ">

                    <div class="paging">
                        <span class="prev">
                            <a href="#">&nbsp;ì´ì </a>
                        </span>
                        <span class="num">
                            <a href="#" class="on">1</a>
                            <a href="#">2</a>
                            <a href="#">3</a>
                            <a href="#">4</a>
                            <a href="#">5</a>
                            <a href="#">6</a>
                            <a href="#">7</a>
                        </span>
                        <span class="next">
                            <a href="#">ë¤ì&nbsp;</a>
                        </span>
                    </div>
                </section>

                <p class="ico info">
                    <strong>Tip!</strong>
                    ì ììê±°ë ë±ììì ìí ë±ì ì ë³´ì ê³µì ê´í ê³ ìì ë°ë¼ ì´ 35ê° ìíêµ°ì ëí´ ìí í¹ì± ë±ì ììì ë°ë¼ ìë ¥í  ì ììµëë¤.
                </p>

                <!-- ìíëª©ë¡ ì»¨íì¸  ë -->
            </section>
        </main>
        <footer>
            <div>
                <p>Copyright Â©kmarket.co.kr All rights reserved. KMARKET ADMINISTRATOR Version 5.4.1.2</p>
            </div>
        </footer>
    </div>
</body>
</html>