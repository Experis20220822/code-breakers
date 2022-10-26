/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package services

import models.User
import repositories.UserRepository

import javax.inject.Inject
import scala.concurrent.Future
import scala.util.Try

class UserService @Inject() (userRepository: UserRepository) extends AsyncUserService {

  def create(user: User): Future[Option[String]] = userRepository.create(user)


}