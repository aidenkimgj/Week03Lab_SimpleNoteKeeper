package servlets;

import java.util.*;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;


public class NoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("edit");
        
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
            // to read files
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));

        String lineStr;
        ArrayList line = new ArrayList();
        int i = 0;

        while((lineStr = br.readLine()) != null) {
            line.add(lineStr);
        }
        br.close();

        Note note = new Note(line.get(0).toString(), line.get(1).toString());

        request.setAttribute("note", note);
        
        if(action == null) {   
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
                   
        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String title = request.getParameter("title");
        String contents = request.getParameter("contents");
        
        Note note = new Note(title, contents);
        
        request.setAttribute("note", note);
        
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false))); 
        
        pw.write(title + "\n");
        pw.write(contents);
        pw.close();
        
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
    }
}