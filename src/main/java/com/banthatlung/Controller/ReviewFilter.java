package com.banthatlung.Controller;

import com.banthatlung.Dao.model.Product;
import com.banthatlung.Dao.model.Review;
import com.banthatlung.services.ProductService;
import com.banthatlung.services.ReviewService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@WebServlet(name = "ReViewFilter", value = "/rfilter")
public class ReviewFilter extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filter = req.getParameter("filter");
        ReviewService reviewService = new ReviewService();
        List<Review> reviews = new ArrayList<>();
        String productId = req.getParameter("pid");

        ProductService service = new ProductService();
        Product detail = service.getDetail(productId);

        switch (filter){
            case "Comment": reviews = reviewService.getReviewsByComment(productId); break;
            case "Img": reviews = reviewService.getReviewsByImg(productId); break;
            case "tatca" : reviews = reviewService.getReviewsByProductId(productId); break;
            default: reviews = reviewService.getReviewsByRating(productId,filter);
        }
        req.setAttribute("pd", detail);
        req.setAttribute("reviews", reviews);
        req.getRequestDispatcher("/View/product-detail.jsp").forward(req, resp);
    }
}
