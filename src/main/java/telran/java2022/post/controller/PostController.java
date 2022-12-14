package telran.java2022.post.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import telran.java2022.post.dto.DatePeriodDto;
import telran.java2022.post.dto.NewCommentDto;
import telran.java2022.post.dto.NewPostDto;
import telran.java2022.post.dto.PostDto;
import telran.java2022.post.service.PostService;

import java.util.List;

@RestController
@RequestMapping("/forum")
@RequiredArgsConstructor
public class PostController {

	final PostService service;


	@PostMapping("/post/{author}")
	public PostDto addPost(@RequestBody NewPostDto newPost, @PathVariable String author) {
		return service.addNewPost(newPost, author);
	}

	@GetMapping("/post/{id}")
	public PostDto getPost(@PathVariable String id) {
		return service.getPost(id);
	}

	@DeleteMapping("/post/{id}")
	public PostDto removePost(@PathVariable String id) {
		return service.removePost(id);
	}

	@PutMapping("/post/{id}")
	public PostDto updatePost(@PathVariable String id, @RequestBody NewPostDto postUpdateDto) {
		return service.updatePost(postUpdateDto, id);
	}

	@PutMapping("/post/{id}/like")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void addLike(@PathVariable String id) {
		service.addLike(id);
	}

	@PutMapping("/post/{id}/comment/{author}")
	public PostDto addComment(@PathVariable String id, @PathVariable String author,
			@RequestBody NewCommentDto newCommentDto) {
		return service.addComment(id, author, newCommentDto);
	}

	@GetMapping("/posts/author/{author}")
	public Iterable<PostDto> getPostsByAuthor(@PathVariable("author") String name) {
		return service.findPostsByAuthor(name);
	}
	
	@PostMapping("/posts/tags")
	public Iterable<PostDto> findPostsByTags(@RequestBody List<String> tags) {
		return service.findPostsByTags(tags);
	}
	
	@PostMapping("/posts/period")
	public Iterable<PostDto> findPostsByDate(@RequestBody DatePeriodDto datePeriodDto) {
		return service.findPostsByDates(datePeriodDto);
	}

}
