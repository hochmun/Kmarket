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
            <section id="admin-product-register">
                <nav>
                    <h3>ìíë±ë¡</h3>
                    <p>
                        HOME > ìíê´ë¦¬ > <strong>ìíë±ë¡</strong>
                    </p>
                </nav>
                <!-- ìíë±ë¡ ì»¨íì¸  ìì -->
                <article>
                    <form action="#">
                        <!-- ìíë¶ë¥ -->
                        <section>
                            <h4>ìíë¶ë¥</h4>
                            <p>
                                ê¸°ë³¸ë¶ë¥ë ë°ëì ì ííìì¼ í©ëë¤. íëì ìíì 1ê°ì ë¶ë¥ë¥¼ ì§ì  í©ëë¤.
                            </p>
                            <table>
                                <tr>
                                    <td>1ì°¨ ë¶ë¥</td>
                                    <td>
                                        <select name="category1">
                                            <option value="cate0">1ì°¨ ë¶ë¥ ì í</option>
                                            <option value="cate11">í¨ìÂ·ìë¥Â·ë·°í°</option>
                                            <option value="cate12">ê°ì Â·ëì§í¸</option>
                                            <option value="cate13">ìíÂ·ìíí</option>
                                            <option value="cate14">íÂ·ë¬¸êµ¬Â·ì·¨ë¯¸</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>2ì°¨ ë¶ë¥</td>
                                    <td>
                                        <select name="category2">
                                            <option value="cate0">2ì°¨ ë¶ë¥ ì í</option>
                                            <option value="cate21">ë¨ì±ìë¥</option>
                                            <option value="cate22">ì¬ì±ìë¥</option>
                                            <option value="cate23">ì¡í</option>
                                            <option value="cate24">ë·°í°</option>
                                        </select>
                                    </td>
                                </tr>
                            </table>
                        </section>

                        <!-- ê¸°ë³¸ì ë³´ -->
                        <section>
                            <h4>ê¸°ë³¸ì ë³´</h4>
                            <p>
                                ê¸°ë³¸ì ë³´ë ë°ëì ìë ¥í´ì¼ í©ëë¤.
                            </p>
                            <table>
                                <tr>
                                    <td>ìíëª</td>
                                    <td><input type="text" name="#"></td>
                                </tr>
                                <tr>
                                    <td>ê¸°ë³¸ì¤ëª</td>
                                    <td>
                                        <span>ìíëª íë¨ì ìíì ëí ì¶ê°ì ì¸ ì¤ëªì´ íìí ê²½ì°ì ìë ¥</span>
                                        <input type="text" name="#">
                                    </td>
                                </tr>
                                <tr>
                                    <td>ì ì¡°ì¬</td>
                                    <td>
                                        <input type="text" name="#">
                                    </td>
                                </tr>
                                <tr>
                                    <td>íë§¤ê°ê²©</td>
                                    <td>
                                        <input type="text" name="#">ì
                                    </td>
                                </tr>
                                <tr>
                                    <td>í ì¸ì¨</td>
                                    <td>
                                        <span>0ì ìë ¥íë©´ í ì¸ì¨ ìì</span>
                                        <input type="text" name="#">ì
                                    </td>
                                </tr>
                                <tr>
                                    <td>í¬ì¸í¸</td>
                                    <td>
                                        <span>0ì ìë ¥íë©´ í¬ì¸í¸ ìì</span>
                                        <input type="text" name="#">ì 
                                    </td>
                                </tr>
                                <tr>
                                    <td>ì¬ê³ ìë</td>
                                    <td>
                                        <input type="text" name="#">ê°
                                    </td>
                                </tr>
                                <tr>
                                    <td>ë°°ì¡ë¹</td>
                                    <td>
                                        <span>0ì ìë ¥íë©´ ë°°ì¡ë¹ ë¬´ë£</span>
                                        <input type="text" name="#">ì
                                    </td>
                                </tr>
                                <tr>
                                    <td>ìí ì¸ë¤ì¼</td>
                                    <td>
                                        <span>í¬ê¸° 190 x 190, ìí ëª©ë¡ì ì¶ë ¥ë  ì´ë¯¸ì§ ìëë¤.</span>
                                        <input type="file" name="#">

                                        <span>í¬ê¸° 230 x 230, ìí ë©ì¸ì ì¶ë ¥ë  ì´ë¯¸ì§ ìëë¤.</span>
                                        <input type="file" name="#">

                                        <span>í¬ê¸° 456 x 456, ìí ìì¸ì ì¶ë ¥ë  ì´ë¯¸ì§ ìëë¤.</span>
                                        <input type="file" name="#">
                                    </td>
                                </tr>
                                <tr>
                                    <td>ìì¸ ìíì ë³´</td>
                                    <td>
                                        <span>í¬ê¸° ê°ë¡ 940px ëì´ ì ì½ìì, í¬ê¸° ìµë 1MB, ìì¸íì´ì§ ìíì ë³´ì ì¶ë ¥ë  ì´ë¯¸ì§ ìëë¤.</span>
                                        <input type="file" name="#">
                                    </td>
                                </tr>
                            </table>
                        </section>

                        <!-- ìíì ë³´ ì ê³µ ê³ ì -->
                        <section>
                            <h4>ìíì ë³´ ì ê³µê³ ì</h4>
                            <p>
                                [ì ììê±°ëì ê´í ìíì ë³´ ì ê³µì ê´í ê³ ì] í­ëª©ì ìê±° ë±ë¡í´ì¼ ëë ì ë³´ìëë¤.
                            </p>
                            <table>
                                <tr>
                                    <td>ìíìí</td>
                                    <td><input type="text" name="" value="ììí"></td>
                                </tr>
                                <tr>
                                    <td>ë¶ê°ì¸ ë©´ì¸ì¬ë¶</td>
                                    <td><input type="text" name="" value="ê³¼ì¸ìí"></td>
                                </tr>
                                <tr>
                                    <td>ììì¦ë°í</td>
                                    <td><input type="text" name="" value="ë°íê°ë¥ - ì ì©ì¹´ë ì í, ì¨ë¼ì¸ íê¸ììì¦"></td>
                                </tr>
                                <tr>
                                    <td>ì¬ììêµ¬ë¶</td>
                                    <td><input type="text" name="" value="ì¬ìì íë§¤ì"></td>
                                </tr>
                                <tr>
                                    <td>ìì°ì§</td>
                                    <td><input type="text" name="" value="êµ­ë´ì°"></td>
                                </tr>
                            </table>
                        </section>

                        <input type="submit" value="ë±ë¡íê¸°">
                    </form>
                </article>

                <p class="ico alert">
                    <strong>Warning!</strong>
                    ì ììê±°ë ë±ììì ìí ë±ì ì ë³´ì ê³µì ê´í ê³ ìì ë°ë¼ ì´ 35ê° ìíêµ°ì ëí´ ìí í¹ì± ë±ì ììì ë°ë¼ ìë ¥í  ì ììµëë¤.
                </p>
                <!-- ìíë±ë¡ ì»¨íì¸  ë -->
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