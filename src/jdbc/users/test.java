//package jdbc.users;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.sql.*;
//import java.util.Scanner;
//
//import static jdbc.boardver2.boardenum.boardenum.*;
//import static jdbc.boardver2.boardenum.boardenum.insertfileinput;
//
//public class test {
//
//
//
//
//    // 회원 정보를 추가하는 메서드
//    private void insertMember(){
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//        conn = DBUtil.getConnection();
//
//        System.out.println();
//        System.out.println("추가할 회원 정보를 입력하세요.");
//
//        int count = 0;
//        String memId = null;  // 회원ID가 저장될 변수
//        do{
//            System.out.print("회원ID >> ");
//            memId = scan.next();
//            count = getMemberCount(memId);
//            if(count>0){
//                System.out.println(memId + "은(는) 이미 등록된 회원ID입니다.");
//                System.out.println("다른 회원ID를 입력하세요.");
//            }
//
//        }while(count>0);
//
//        System.out.print("회원이름 >> ");
//        String memName = scan.next();
//
//        System.out.print("비밀번호 >> ");
//        String memPass = scan.next();
//
//        System.out.print("전화번호 >> ");
//        String memTel = scan.next();
//
//        scan.nextLine();  // 입력 버퍼 비우기
//        System.out.print("회원주소 >> ");
//        String memAddr = scan.nextLine();
//
//        try {
//            //DB 연결  후 쿼리 작성
////            conn = DBUtil.getConnection();
//
//
//            String sql = "" +
//                    "INSERT INTO users2 (userid,username,userpassword,userTel,useraddr) " +
//                    "VALUES (?,?,?,?,?); ";
//
//            pstmt = conn.prepareStatement(sql);
//
//            System.out.printf(inserttile.getText());
//            pstmt.setString(1,memId);
//            pstmt.setString(2,memName);
//            pstmt.setString(3,memPass);
//            pstmt.setString(4,memTel);
//            pstmt.setString(5,memAddr);
//
//
//            int cnt = pstmt.executeUpdate();
//
//            if( cnt>0 ){
//                System.out.println("회원 정보 추가 성공!!!");
//            }else{
//                System.out.println("회원 정보 추가 실패~~~");
//            }
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            if(pstmt!=null) try{ pstmt.close();   }catch(SQLException e){}
//            if(conn!=null) try{ conn.close();   }catch(SQLException e){}
//        }
//
//
//        private Connection connection;
//
//    public boardInsert(Connection connection) {
//            this.connection = connection;
//        }
//
//
//        public void insert() {
//            Scanner in = new Scanner(System.in);
//
//            try {
//                //3. 매개변수화된 SQL 문 작성
//                String query = "" +
//                        "INSERT INTO boards (btitle,bcontent,bwriter,bdate,bfilename,bfiledata) " +
//                        "VALUES (?,?,?,now(),?,?); ";
//
//                PreparedStatement pstmt = connection.prepareStatement(query , Statement.RETURN_GENERATED_KEYS);
//
//                System.out.printf(inserttile.getText());
//                pstmt.setString(1, in.nextLine());
//                System.out.printf(insertcontent.getText());
//                pstmt.setString(2,in.nextLine());
//                System.out.printf(insertwriter.getText());
//                pstmt.setString(3,in.nextLine());
//                System.out.printf(insertfilename.getText());
//                String image = in.nextLine();
//                pstmt.setString(4,image);
//                System.out.println(insertfileinputex.getText());
//                System.out.printf(insertfileinput.getText());
//                pstmt.setBlob(5,new FileInputStream(in.nextLine()+"/"+image));
//
//
//                //4. SQL문 실행
//                int rows =  pstmt.executeUpdate();
//                System.out.println(rows + " rows inserted");
//
//                //bno 값 얻어오기
//                if(rows == 1) {
//                    ResultSet rs = pstmt.getGeneratedKeys();
//                    if(rs.next()){
//                        int bno = rs.getInt(1);
//                        System.out.println(bno);
//                    }
//                    rs.close();
//
//                }
//
//                //5. PreparedStatement 객체 닫기
//                pstmt.close();
//
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            } catch (FileNotFoundException e) {
//                throw new RuntimeException(e);
//            }
//
//        }
//
//    }
//
//
//
//
//
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//}
