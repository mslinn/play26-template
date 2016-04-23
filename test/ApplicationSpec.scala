import play.api.test._
import play.api.test.Helpers._
import org.scalatest._
import play.test.WithApplication

class ApplicationSpec extends WordSpec with MustMatchers {
  "Application" should {
    "send 404 on a bad request" in new WithApplication {
      route(FakeRequest(GET, "/boum")) mustBe None
      ()
    }

    "render the index page" in new WithApplication{
      val home = route(FakeRequest(GET, "/")).get
      status(home) must equal(OK)
      contentType(home) mustBe Some("text/html")
      ()
    }
  }
}
