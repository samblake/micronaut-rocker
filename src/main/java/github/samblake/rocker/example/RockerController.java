package github.samblake.rocker.example;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.views.View;
import io.micronaut.views.rocker.RockerWritable;

import static io.micronaut.core.util.CollectionUtils.mapOf;
import static io.micronaut.http.HttpResponse.ok;
import static io.micronaut.http.MediaType.TEXT_HTML;

@Controller("/rocker")
public class RockerController {

	@Get("/dynamic")
	@View("index")
	@Produces(TEXT_HTML)
	public HttpResponse<?> dynamicTemplate() {
		return ok(mapOf("message", "Dynamic"));
	}

	@Get("/static")
	@Produces(TEXT_HTML)
	public HttpResponse<?> staticTemplate() {
		return ok(new RockerWritable(views.index.template("Static")));
	}

}