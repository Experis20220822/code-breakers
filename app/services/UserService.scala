/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package services

import models.User
import repositories.UserRepository

import javax.inject.Inject
import scala.concurrent.Future

class UserService @Inject() (userRepository: UserRepository) extends AsyncUserService {
  import scala.concurrent.ExecutionContext.Implicits.global
  override def create(user: User): Future[Option[String]] = userRepository.create(user)

  override def getUsername(username: String): Future[Option[User]] = userRepository.getUsername(username)
  override def findById(id: String): Future[Option[User]] = Future(Some (User("FakeID", "FakeEmail", "fakePassword", "fakePassword")))


}
