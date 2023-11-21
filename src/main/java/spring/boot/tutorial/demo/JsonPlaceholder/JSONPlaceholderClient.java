package spring.boot.tutorial.demo.JsonPlaceholder;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
    value = "JsonPlaceholder",
    url = "https://jsonplaceholder.typicode.com/"
)
public interface JSONPlaceholderClient {

    @GetMapping("posts")
    List<Post> getPosts();

    @GetMapping("posts/{postId}")
    Post getPost(@PathVariable("postId") Integer postId);


}
